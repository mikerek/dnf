package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.ProductoMedidaBean;
import com.umeni.db.connection.ConexBD;

public class ProductoMedidaDAO {
	
public static ArrayList< ProductoMedidaBean > obtenerTodasLasMedidas( ){
		
		String query="SELECT id_producto_medida, medida FROM producto_medida";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		ArrayList< ProductoMedidaBean > beanList = new ArrayList< ProductoMedidaBean >();
 		
		try {
			ps = con.prepareStatement( query );	
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				ProductoMedidaBean bean = new ProductoMedidaBean();
				bean.setId_producto_medida( rs.getInt( "id_producto_medida" ) );
				bean.setMedida( rs.getString( "medida" ) );
				beanList.add( bean );
				
			}
			con.close();
		} 
		catch (SQLException e) {
			
			System.out.println( "Hubo un error en la base de datos: " );
			e.printStackTrace();
			
		}	
		return beanList;
		
	}

}
