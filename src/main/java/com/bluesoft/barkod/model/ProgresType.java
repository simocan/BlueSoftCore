package com.bluesoft.barkod.model;

import java.util.HashMap;
import java.util.Map;

public enum ProgresType {

	PRIMARY("Beklemede", "0", "table-primary"),
	SECONDARY("Ön İmalat", "1", "table-secondary"),
	DANGER("İmalat", "2", "table-danger"), 
	SUCCES("TRANSFERE HAZIRDIR.", "3", "table-success"),
	INFO("ÖN İMALAT", "4", "table-info"),
	DARK("İMALAT", "5", "table-dark"),
	LIGHT("İMALAT", "6", "table-light");


	private final String levelCode;
	private final String desc;
	private final String color;

	ProgresType(String desc, String levelCode, String color) {
		this.desc = desc;
		this.levelCode = levelCode;
		this.color = color;
	}

	public String getLevelCode() {
		return this.levelCode;
	}

	public String getDes() {
		return this.desc;
	}

	public String getColor() {
		return this.color;
	}
	
	public static ProgresType getValue(String code) {                                                                        
        return MAP.get(code);
    }

	private static final Map<String, ProgresType> MAP = new HashMap<String, ProgresType>();
	static {
		for (ProgresType s : ProgresType.values()) {
			MAP.put(s.getLevelCode(), s);
		}
	}
}
