package ch.bildspur.ads

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class FlowChartTest {

    @Test
    fun flowChartTest()
    {
        // read code
        val lines = Files.readAllLines(Paths.get("examples/project.ads"))
        val parser = FlowChartParser()

        // parse
        parser.parse(lines)
    }
}