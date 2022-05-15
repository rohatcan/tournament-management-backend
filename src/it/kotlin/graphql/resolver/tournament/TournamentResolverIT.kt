package graphql.resolver.tournament

import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.rohat.tournamentmanagementapp.TournamentManagementAppApplication
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [TournamentManagementAppApplication::class]
)
//@ActiveProfiles("test")
//@GraphQLTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TournamentResolverIT {
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





}