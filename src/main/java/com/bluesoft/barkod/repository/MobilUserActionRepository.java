package com.bluesoft.barkod.repository;

import java.util.List;

import com.bluesoft.barkod.entity.TblSanalBarkod;

public interface MobilUserActionRepository {
	
	public int userActions(String sanalBarkodNo,Long userId,List<TblSanalBarkod> sanalBakodList);

}
