package graphql.resolver

import java.lang.String.format
import org.assertj.core.api.Assertions.assertThat
import org.skyscreamer.jsonassert.JSONAssert.assertEquals

import com.graphql.spring.boot.test.GraphQLResponse
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.rohat.tournamentmanagementapp.TournamentManagementAppApplication
import io.micrometer.core.instrument.util.IOUtils
import org.json.JSONException
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import java.io.IOException
import java.nio.charset.StandardCharsets


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = arrayOf(
        TournamentManagementAppApplication::class
    )
)
class UserResolverIT {

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    private val GRAPHQL_QUERY_REQUEST_PATH = "graphql/resolver/request/%s.graphql"
    private val GRAPHQL_QUERY_RESPONSE_PATH = "graphql/resolver/response/%s.json"


    @Test
    @Throws(IOException::class, JSONException::class)
    fun `Should Get User By ID`() {
        val testName = "get_user_by_id"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = read(format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Throws(IOException::class)
    private fun read(location: String): String {
        return IOUtils.toString(
            ClassPathResource(location).inputStream, StandardCharsets.UTF_8
        )
    }

}