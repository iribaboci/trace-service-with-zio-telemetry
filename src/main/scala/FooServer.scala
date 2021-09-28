object FooServer:
  // 1) 
  val propagator: TextMapPropagator =
    W3CTraceContextPropagator.getInstance()
  val setter: TextMapSetter[mutable.Map[String, String]] =
    (carrier, key, value) => carrier.update(key, value)
  val errorMapper: PartialFunction[Throwable, StatusCode] = {
    case _ => StatusCode.UNSET
  }
  val api = Http.collectM[ZioRequest] {
    // 2)
    case req @ Method.GET -> Root / "foo" =>
      val response = for
        _    <- zio.console.putStrLn("foo received message ")
        resp <- sendRequestToBar
      yield ZioResponse.text("sent")

      val span = s"${req.method.toString()} ${req.url.asString}"

      Tracing
        .root(span, SpanKind.SERVER, errorMapper)(response) // 3)
  }