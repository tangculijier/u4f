package com.u4f.servlet;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  javax.servlet.ServletOutputStream;
import com.u4f.tools.DBTools;
import com.u4f.tools.GetImageFromDatabase;


public class GetImage extends HttpServlet {
	

	static Connection conn=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public GetImage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream sout = response.getOutputStream();
		response.setContentType("image/jpeg");
		int id = Integer.parseInt(request.getParameter("id"));

		conn = DBTools.getConn(conn);

		try {

			ps = conn.prepareStatement("select ScenerySpotPicture from ScenerySpot where ScenerySpotId="
							+ id);

			rs = ps.executeQuery();

			// Blob image_blob=rs.getBlob("ScenerySpotPicture");
			InputStream in = null;

			if (rs.next()) {
				in = rs.getBinaryStream("ScenerySpotPicture");

				byte image[] = new byte[1024];
				while (in.read(image) != -1) {
					sout.write(image);
				}
				sout.flush();

				// sout.close();
				rs.close();
				ps.close();
				conn.close();

			}

		} catch (Exception ex) {
			System.out.println("Found some error : " + ex);
		} finally {

			DBTools.close(conn, ps, rs);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
