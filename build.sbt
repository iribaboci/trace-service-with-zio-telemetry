val scala3Version = "3.0.2"

val zioHttpV = "1.0.0.0-RC17"
val openTracingV = "0.33.0"
val opentelemetryV = "1.6.0"
val zioTelemetryV = "0.8.2"
val log4jV = "2.14.1"
val sttpV = "3.3.14"
val elasticV = "7.15.0"
val grpcNettyShadedV = "1.40.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "trace-service-with-zio-telemetry",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.apache.logging.log4j" % "log4j-slf4j-impl" % log4jV,
      "io.d11" %% "zhttp" % zioHttpV, // 1)
      "dev.zio" %% "zio-opentelemetry" % zioTelemetryV, // 2)

      "io.opentelemetry" % "opentelemetry-exporter-jaeger" % opentelemetryV,
      "io.opentelemetry" % "opentelemetry-sdk"             % opentelemetryV,
      "io.grpc"          % "grpc-netty-shaded"             % grpcNettyShadedV,

      "com.novocode" % "junit-interface" % "0.11" % "test",

      "com.softwaremill.sttp.client3" %% "core" % sttpV, // 3)
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % sttpV,
      "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % elasticV // 4
    )

  )
