package com.yrkj.extract.service;

import jxl.Sheet;
import jxl.write.WritableSheet;

public interface IExtract {

	public void copy(Sheet formSheet, WritableSheet toWritableSheet);
}
