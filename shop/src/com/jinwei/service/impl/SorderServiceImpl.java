package com.jinwei.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;
import com.jinwei.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	
	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false;
		Sorder sorder = productToSorder(product);
		//判断当前购物项是否重复 如果重复则只增加数量即可 
		for(Sorder old:forder.getSorderSet()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复 添加数量即可
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//说明当前购物项 在购物车中是不存在的 新添加即可
		if(!isHave){
			//建立购物车与购物项的关联 此时forder.id为null  但是在入库的时候先入库购物车 再入库购物项 那时forder就有主键了
			sorder.setForder(forder);
			forder.getSorderSet().add(sorder);
		}
				return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Sorder sorder, Forder forder) {
		for(Sorder temp:forder.getSorderSet()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public List<Object> querySale(int number) {
		String hql = "SELECT s.name,sum(s.number) FROM Sorder s JOIN s.product GROUP BY s.product.id";
		return getSession().createQuery(hql).setFirstResult(0).setMaxResults(number).list();
		
	}



	

}
