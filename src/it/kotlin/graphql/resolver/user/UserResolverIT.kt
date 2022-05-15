package graphql.resolver.user

import com.graphql.spring.boot.test.GraphQLResponse
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.rohat.tournamentmanagementapp.TournamentManagementAppApplication
import graphql.resolver.helper.ITHelper
import io.micrometer.core.instrument.util.IOUtils
import org.assertj.core.api.Assertions.assertThat
import org.json.JSONException
import org.junit.jupiter.api.*
import org.skyscreamer.jsonassert.JSONAssert.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import java.io.IOException
import java.lang.String.format
import java.nio.charset.StandardCharsets


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = arrayOf(
        TournamentManagementAppApplication::class
    )
)
//@ActiveProfiles("test")
//@GraphQLTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserResolverIT {

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    private val GRAPHQL_QUERY_REQUEST_PATH = "graphql/resolver/request/%s.graphql"
    private val GRAPHQL_QUERY_RESPONSE_PATH = "graphql/resolver/response/%s.json"

    @BeforeAll
    fun setUp() {

        // add jwt token
        val token =
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MjdlYzliZmI3Yzc4NzQxMWIyMjZkYzAiLCJpYXQiOjE2NTI0Nzg2NzAsImV4cCI6MTY1MjU1NjQwN30.eqUMUrrhe2WOBvahymC4K1MUOdHFQLPLyLvh8aIwe_sDFDZrhKXzI_IANeXDa35dEcOvoPbn7CtdCZH_bjplYA"
        graphQLTestTemplate.headers.add("Authorization", "Bearer $token")
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(1)
    fun `Should Get User By ID`() {
        val testName = "get_user_by_id"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(2)
    fun `Should Not Get User By ID Without Auth Token`() {

        graphQLTestTemplate.headers.remove("Authorization")
        val testName = "get_user_by_id"
        val responseJson = "not_get_user_by_id"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(format(GRAPHQL_QUERY_RESPONSE_PATH, responseJson))
        assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(graphQLResponse.get("$.data").isNullOrBlank())
        assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }


}