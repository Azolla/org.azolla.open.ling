/*
 * @(#)Encoding.java		Created at 2013-7-3
 * 
 * Copyright (c) 2011-2013 azolla.org All rights reserved.
 * Azolla PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package org.azolla.open.ling.io;

/**
 * The coder is very lazy, nothing to write for this Encoding class
 *
 * @author 	sk@azolla.org
 * @since 	ADK1.0
 */
public enum Encoding
{
	UTF8("UTF-8"),
	ASCII("ASCII"),
	GBK("GBK");

	private String	encoding;

	private Encoding(String encoding)
	{
		this.encoding = encoding;
	}

	public String getEncoding()
	{
		return encoding;
	}

	/**
	 * @see java.lang.Enum#toString()
	 * @return
	 */
	@Override
	public String toString()
	{
		return encoding;
	}
}