package Connection;


import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;

public class ConnectionSerial implements SerialPortEventListener {

    private SerialPort serialPort;
    private final String namePort;
    CommPortIdentifier portIdentifier;
    private String inputLine;
    char[] inputlineC = new char[16];
    boolean flag = true;

    public char[] getInputlineC() {
        return inputlineC;
    }

    public void setInputlineC(char[] inputlineC) {
        this.inputlineC = inputlineC;
    }
    
    

    public String getInputLine() {
        return inputLine;
    }

    public void setInputLine(String inputLine) {
        this.inputLine = inputLine;
    }
    
    
    
    public ConnectionSerial(String portName) {
        this.namePort = portName;
    }

    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public String initialize() throws NoSuchPortException {
        portIdentifier = null;
        
        String check = null;

        try {
            portIdentifier = CommPortIdentifier.getPortIdentifier(namePort);
            if (portIdentifier.isCurrentlyOwned()) {
                System.out.println("Port in use!");
                check = "1";
                return check;
            } else {
                check = "0";
                // open serial port, and use class name for the appName.
                serialPort = (SerialPort) portIdentifier.open(this.getClass().getName(),
                        TIME_OUT);

                // set port parameters
                serialPort.setSerialPortParams(DATA_RATE,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);

                return check;
            }

        } catch (PortInUseException | UnsupportedCommOperationException e) {
            System.err.println(e.toString());
        }
        return check;
    }
    
    public boolean checkConnect(){
        boolean flag = false;
        if(portIdentifier.isCurrentlyOwned()){
            flag = true;
        }
        return flag;
    }
    

    public void startGetdata() throws IOException, TooManyListenersException {
        // Mở luồng dữ liệu
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();

        // Thêm sự kiện lắng nghe
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
    }

    public void send(String data) { // truyền vào data cần gửi
        try {           
            char[] buffer = data.toCharArray();
            byte[] b = new byte[buffer.length];
            for (int i = 0; i < b.length; i++) {
                 b[i] = (byte) buffer[i];
                 System.out.println(b[i]);
            }
            output.write(b);

//            output.write(data.getBytes());
//            System.out.println(data.getBytes());
            // mã hóa dữ liệu dưới dạng Byte 
            // gửi thông qua luồng dữ liệu SerialPort cổng ra
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public String read(String input) {
        inputLine = input;
        System.out.println(inputLine);
        return inputLine;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            int i =0;
            int c =0;
            try {

            while((c = input.read()) != -1 && i < 16) {
                 inputlineC[i++] = (char) c;
                 inputLine = new String(inputlineC);
                 setInputLine(inputLine);
//                 System.out.println(getInputLine());
            }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
