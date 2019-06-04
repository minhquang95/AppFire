/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreDao;

import java.sql.Connection;

/**
 *
 * @author Ki Thuat 88
 */
public interface FireDao {
    void saveFireStatus();
    Connection connectionMysql();
}
