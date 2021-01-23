import org.junit.jupiter.api.Test;
import org.junit.platform.testkit.engine.EngineTestKit;
import tech.getrealgood.util.engine.CustomTestEngine;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectFile;

public class CustomTestEngineTests {

    @Test
    void verifyCustomTestEngineContainerStats() {

        // you should provide your own absolute or relative path to the testX.txt files

        EngineTestKit
                .engine(new CustomTestEngine())
                .selectors(
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test1.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test2.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test3.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test4.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test5.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test6.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test7.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test8.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test9.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test10.txt")
                )
                .execute()
                .containerEvents()
                .assertStatistics(stats -> stats.started(1).succeeded(1)
                );

    }

    @Test
    void verifyCustomTestEngineTestStats() {

        // you should provide your own absolute or relative path to the testX.txt files

        EngineTestKit
                .engine(new CustomTestEngine())
                .selectors(
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test1.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test2.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test3.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test4.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test5.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test6.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test7.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test8.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test9.txt"),
                        selectFile("D:\\Codes\\GRG001JUnitAsAHabitTestEngine\\tests\\test10.txt")
                )
                .execute()
                .testEvents()
                .assertStatistics(stats -> stats.started(10).succeeded(9).failed(1)
                );

    }
}
