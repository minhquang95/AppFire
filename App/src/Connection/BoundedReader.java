/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Ki Thuat 88
 */
public class BoundedReader extends BufferedReader {
     private final int  bufferSize;
    private       char buffer[];

    BoundedReader(final BufferedReader in, final int bufferSize) {
        super(in);
        this.bufferSize = bufferSize;
        this.buffer     = new char[bufferSize];
    }

    @Override
    public String readLine() throws IOException {
        int no;

        /* read up to bufferSize */
        if((no = this.read(buffer, 0, bufferSize)) == -1) return null;
        String input = new String(buffer, 0, no).trim();

        /* skip the rest */
        while(no >= bufferSize && ready()) {
            if((no = read(buffer, 0, bufferSize)) == -1) break;
        }

        return input;
    }
}
