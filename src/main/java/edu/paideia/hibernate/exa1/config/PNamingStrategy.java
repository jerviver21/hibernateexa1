package edu.paideia.hibernate.exa1.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


/**
 * Taller3
 * Sobreescribimos clase para estandarizar nombres de tablas en base de datos
 */
public class PNamingStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl {
	
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return new Identifier("" + name.getText(), name.isQuoted());
	}

}
