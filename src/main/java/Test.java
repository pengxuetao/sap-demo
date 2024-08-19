import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

import java.util.Properties;

public class Test {

    public static void main(String[] args) {

        try {

            DestinationDataProvider provider = new DestinationDataProvider() {
                @Override
                public Properties getDestinationProperties(String s) {
                    Properties connectProperties = new Properties();
                    connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "172.16.30.64");
                    connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "10");
                    connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "EQ2");
                    connectProperties.setProperty(DestinationDataProvider.JCO_USER, "GYMD");
                    connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "Sap123456");
                    connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "ZH");
                    return connectProperties;
                }

                @Override
                public boolean supportsEvents() {
                    return false;
                }

                @Override
                public void setDestinationDataEventListener(DestinationDataEventListener destinationDataEventListener) {

                }
            };

            Environment.registerDestinationDataProvider(provider);

            JCoDestination destination = JCoDestinationManager.getDestination("SAPSystem");
            // ping
            destination.ping();

            JCoRepository repo = destination.getRepository();
            JCoFunction function = repo.getFunction("func_name");

            // 设置参数
            function.getImportParameterList().setValue("param1", "value1");
            function.getImportParameterList().setValue("param2", "value2");

            // 调用RFC
            function.execute(destination);

            // 获取结果
            String result = function.getExportParameterList().getString("result");
            System.out.println("Result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
