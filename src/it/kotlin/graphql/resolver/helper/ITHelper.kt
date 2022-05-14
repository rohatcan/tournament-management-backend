package graphql.resolver.helper

import io.micrometer.core.instrument.util.IOUtils
import org.springframework.core.io.ClassPathResource
import java.io.IOException
import java.nio.charset.StandardCharsets

class ITHelper {
    companion object {

        @Throws(IOException::class)
        fun read(location: String): String {
            return IOUtils.toString(
                ClassPathResource(location).inputStream, StandardCharsets.UTF_8
            )
        }
    }
}