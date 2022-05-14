package graphql.resolver.game

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
class GameResolverIT {

    @Autowired
    lateinit var graphQLTestTemplate: GraphQLTestTemplate

    private val GRAPHQL_QUERY_REQUEST_PATH = "graphql/resolver/request/game/%s.graphql"
    private val GRAPHQL_QUERY_RESPONSE_PATH = "graphql/resolver/response/game/%s.json"

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
    fun `Should Save a Game`() {

        val testName = "create_game"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

    @Test
    @Throws(IOException::class, JSONException::class)
    @Order(2)
    fun `Should Delete a Game`() {

        val testName = "delete_game"
        val graphQLResponse: GraphQLResponse = graphQLTestTemplate
            .postForResource(String.format(GRAPHQL_QUERY_REQUEST_PATH, testName))
        val expectedResponseBody = ITHelper.read(String.format(GRAPHQL_QUERY_RESPONSE_PATH, testName))
        Assertions.assertThat(graphQLResponse.statusCode).isEqualTo(HttpStatus.OK)
        JSONAssert.assertEquals(expectedResponseBody, graphQLResponse.rawResponse.body, true)
    }

}