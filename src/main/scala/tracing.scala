import zio.*
import io.opentelemetry.exporter.jaeger.JaegerGrpcSpanExporter
import io.opentelemetry.api.trace.*
import io.opentelemetry.sdk.OpenTelemetrySdk
import io.opentelemetry.sdk.resources.Resource
import io.opentelemetry.sdk.trace.*
import io.opentelemetry.sdk.trace.`export`.SimpleSpanProcessor
import io.opentelemetry.api.common.Attributes
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes