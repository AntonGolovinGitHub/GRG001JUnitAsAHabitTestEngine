package tech.getrealgood.util.engine;

import org.junit.platform.engine.*;
import org.junit.platform.engine.discovery.FileSelector;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;

import java.io.IOException;
import java.nio.file.Files;

public class CustomTestEngine implements TestEngine {

    @Override
    public String getId() {
        return "custom-test-engine";
    }

    @Override
    public TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId) {

        EngineDescriptor engineDescriptor = new EngineDescriptor(uniqueId, "My Custom Test Engine");

        discoveryRequest.getSelectorsByType(FileSelector.class).forEach(selector -> {
            try {
                engineDescriptor.addChild(new CustomTestDescriptor(engineDescriptor.getUniqueId(),
                        selector.getFile().getName(), Files.readAllLines(selector.getFile().toPath())));
            } catch (IOException e) {
                // do something here
            }
        });

        return engineDescriptor;
    }

    @Override
    public void execute(ExecutionRequest request) {

        TestDescriptor engineDescriptor = request.getRootTestDescriptor();
        EngineExecutionListener listener = request.getEngineExecutionListener();

        listener.executionStarted(engineDescriptor);

        for (TestDescriptor testDescriptor : engineDescriptor.getChildren()) {

            CustomTestDescriptor descriptor = (CustomTestDescriptor) testDescriptor;
            listener.executionStarted(testDescriptor);

            if (descriptor.getFileContent().get(0).equals("Test")) {
                listener.executionFinished(testDescriptor, TestExecutionResult.successful());
            } else {
                listener.executionFinished(testDescriptor,
                        TestExecutionResult.failed(new AssertionError("Test failed.")));
            }
        }

        listener.executionFinished(engineDescriptor, TestExecutionResult.successful());

    }

}
