package graphql.resolver.game

import com.rohat.tournamentmanagementapp.TournamentManagementAppApplication
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = arrayOf(
        TournamentManagementAppApplication::class
    )
)
//@ActiveProfiles("test")
//@GraphQLTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class GameResolverIT {
}