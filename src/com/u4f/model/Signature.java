package com.u4f.model;

public class Signature
{

	private int signatureId;
	private String signatureTime;
	private double signatureLng;
	private double signatureLati;
	private int userId;
	private int sceneryId;
	public int getSignatureId()
	{
		return signatureId;
	}
	public void setSignatureId(int signatureId)
	{
		this.signatureId = signatureId;
	}
	public String getSignatureTime()
	{
		return signatureTime;
	}
	public void setSignatureTime(String signatureTime)
	{
		this.signatureTime = signatureTime;
	}
	public double getSignatureLng()
	{
		return signatureLng;
	}
	public void setSignatureLng(double signatureLng)
	{
		this.signatureLng = signatureLng;
	}
	public double getSignatureLati()
	{
		return signatureLati;
	}
	public void setSignatureLati(double signatureLati)
	{
		this.signatureLati = signatureLati;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getSceneryId()
	{
		return sceneryId;
	}
	public void setSceneryId(int sceneryId)
	{
		this.sceneryId = sceneryId;
	}
	
	
}
