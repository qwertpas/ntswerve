import java.io.IOException;

import com.illposed.osc.MessageSelector;
import com.illposed.osc.OSCMessageEvent;
import com.illposed.osc.OSCMessageListener;
import com.illposed.osc.messageselector.OSCPatternAddressMessageSelector;
import com.illposed.osc.transport.OSCPort;
import com.illposed.osc.transport.OSCPortIn;

public class OSCTest {
    
    public static void main(String[] args) {
        // listens on the wildcard address (all local network interfaces)
        // on the given port (the default one) 
        OSCPortIn receiver;
        try {
            receiver = new OSCPortIn(OSCPort.DEFAULT_SC_OSC_PORT);
            OSCMessageListener listener = new OSCMessageListener() {
                public void acceptMessage(OSCMessageEvent event) {
                    System.out.println("Message received: " + event.getMessage().getAddress());
                }
            };
            MessageSelector selector = new OSCPatternAddressMessageSelector("/message/receiving");
            receiver.getDispatcher().addListener(selector, listener);
    
            receiver.startListening();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}
