package org.bigjava.test;

import java.sql.Connection;

import org.bigjava.utils.JDBCutils;
import org.junit.Test;


public class JDBCTest {
	@Test
	public	static void main(String[]args) {
		for (int i = 0; i < 100; i++) {
			Connection conn = JDBCutils.getConnection();
			System.out.println(conn);
			JDBCutils.close(conn);
		}
	}
}
