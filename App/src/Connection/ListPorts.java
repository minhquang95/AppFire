/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 *
 * @author Ki Thuat 88
 */
public class ListPorts {
        public List<String> ListAvailablePorts (){
        List<String> listAvailablePorts = new ArrayList<>(); // thêm 1 danh sách chúa các Port
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        while(ports.hasMoreElements()){

            String stringGetName = ((CommPortIdentifier)ports.nextElement()).getName();
            listAvailablePorts.add(stringGetName); // lưu port ở máy tính vào list
        }
        return listAvailablePorts; // trả vệ giá trị list 
    }
}
