
package bookshop;

import java.sql.PreparedStatement;


public interface Injecterble {
    PreparedStatement inject(PreparedStatement ps) throws Exception; 
}
