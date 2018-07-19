package bean.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.daoclass.WashUse;
import bean.mapper.ClientMapper;
import bean.mapper.ClothMapper;
import bean.mapper.OrderMapper;
import bean.mapper.WashUseMapper;
import bean.service.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class WashUseServiceImpl implements WashUseService {

	@Autowired
	public WashUseMapper wash;
	public int delete(String Uname) {
		// TODO Auto-generated method stub
		
		
		wash.deleteWashUse(Uname);
		return 0;
	}

	public List<WashUse> findAll() {
		// TODO Auto-generated method stub
		
		return wash.returnAllWashuseInfo();
	}

	public WashUse findOne(String Uname) {
		// TODO Auto-generated method stub
		
		return wash.returnWashuseInfoByName(Uname);
	}

	public int insert(String Uname, int Unum) {
		// TODO Auto-generated method stub
		WashUse one = new WashUse();
		one.setUname(Uname);
		one.setUnum(Unum);
		wash.addWashUse(one);
		return 0;
	}

	public int update(String Uname_1, String Uname_2, int Unum) {
		// TODO Auto-generated method stub
		WashUse one = wash.returnWashuseInfoByName(Uname_1);
		one.setUname(Uname_2);
		one.setUnum(Unum);
		wash.deleteWashUse(Uname_1);
		wash.addWashUse(one);
		return 0;
	}
	
}
