package action

import com.graphql.spring.boot.test.GraphQLResponse
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.rohat.tournamentmanagementapp.TournamentManagementAppApplication
import graphql.resolver.helper.ITHelper
import org.assertj.core.api.Assertions
import org.json.JSONException
import org.junit.jupiter.api.*
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import java.io.IOException


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [TournamentManagementAppApplication::class]
)
//@ActiveProfiles("test")
//@GraphQLTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinishTournament {

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    private val GRAPHQL_QUERY_REQUEST_PATH = "graphql/action/request/%s.graphql"
    private val GRAPHQL_QUERY_RESPONSE_PATH = "graphql/action/response/%s.json"

    @BeforeEach
    fun setUp() {

        // add jwt token
        val token =
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MjdlYzliZmI3Yzc4NzQxMWIyMjZkYzAiLCJpYXQiOjE2NTI1OTcxNzcsImV4cCI6MTY1MjY3NDkzN30.nD2cj1EY8GqRFl6cL5XYpk1gy5p8m2mPxRu8Llihh0R-D0tKvHS5isjyM15k5IWfRmM_QNpeGK8di3gAOSzgQQ"
        graphQLTestTemplate.headers.add("Authorization", "Bearer $token")
    }


    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(1)
    fun `create owner`() {

        graphQLTestTemplate.headers.remove("Authorization")
        val testName = "create_owner"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(2)
    fun `should create game`() {

        val testName = "create_game"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(3)
    fun `should create tournament`() {

        val testName = "create_tournament"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }


    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(4)
    fun `should create participation`() {

        val testName = "create_participant"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(5)
    fun `should update tournament`() {

        val testName = "update_tournament"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(6)
    fun `should choose winner`() {

        val testName = "choose_winner"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(7)
    fun `delete owner`() {

        val testName = "delete_owner"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(8)
    fun `should delete game`() {

        val testName = "delete_game"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(9)
    fun `should delete participant`() {

        val testName = "delete_participant"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(10)
    fun `should delete tournament`() {

        val testName = "delete_tournament"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }
}