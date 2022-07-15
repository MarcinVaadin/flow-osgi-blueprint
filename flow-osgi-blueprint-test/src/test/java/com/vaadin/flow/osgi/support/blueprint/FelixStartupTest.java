package com.vaadin.flow.osgi.support.blueprint;

import org.apache.felix.framework.FrameworkFactory;
import org.junit.Test;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

import java.util.HashMap;
import java.util.Map;

public class FelixStartupTest {

    @Test
    public void DependenciesCheckTest() {

        Map<String, String> configuration = new HashMap<>();
        configuration.put("felix.log.level", "4"); // DEBUG

        Framework m_fwk = new FrameworkFactory().newFramework(configuration);
        try {
            m_fwk.init();
//            AutoProcessor.process(null, m_fwk.getBundleContext());
            m_fwk.start();
        } catch (Exception ex) {
            System.err.println("Could not create framework: " + ex);
            ex.printStackTrace();
        } finally {
            try {
                m_fwk.stop();
            } catch (BundleException ex) {
                System.err.println("Could not stop framework: " + ex);
                ex.printStackTrace();
                System.exit(-1);
            }
        }
    }

}
