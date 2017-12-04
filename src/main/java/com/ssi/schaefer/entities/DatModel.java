package com.ssi.schaefer.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class DatModel implements Serializable {

	/*
	 * 
	 * -------------- Spring Configs
	 * 
	 **/

	public static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Transient
	private String wamasHostIpRequested;

	public String getWamasHostIpRequested() {
		return wamasHostIpRequested;
	}

	public void setWamasHostIpRequested(String wamasHostIpRequested) {
		this.wamasHostIpRequested = wamasHostIpRequested;
	}

	/**
	 * 
	 * -------------- ARTICLE INSERT
	 * 
	 */

	@Transient
	private String articleInsertAFrame, articleInsertPbl, articleInsertPdc;

	public String getArticleInsertAFrame() {
		return articleInsertAFrame;
	}

	public void setArticleInsertAFrame(String articleInsertAFrame) {
		this.articleInsertAFrame = articleInsertAFrame;
	}

	public String getArticleInsertPbl() {
		return articleInsertPbl;
	}

	public void setArticleInsertPbl(String articleInsertPbl) {
		this.articleInsertPbl = articleInsertPbl;
	}

	public String getArticleInsertPdc() {
		return articleInsertPdc;
	}

	public void setArticleInsertPdc(String articleInsertPdc) {
		this.articleInsertPdc = articleInsertPdc;
	}

	/*
	 * 
	 * -------------- ORDER INSERT
	 * 
	 */

	@Transient
	private String orderInsertAframe, orderInsertPblUp, orderInsertPblDown, orderInsertPblMixed, orderInsertPdc, orderInsertPrize, orderInsertMix;

	public String getOrderInsertAframe() {
		return orderInsertAframe;
	}

	public void setOrderInsertAframe(String orderInsertAframe) {
		this.orderInsertAframe = orderInsertAframe;
	}

	public String getOrderInsertPblUp() {
		return orderInsertPblUp;
	}

	public void setOrderInsertPblUp(String orderInsertPblUp) {
		this.orderInsertPblUp = orderInsertPblUp;
	}

	public String getOrderInsertPblDown() {
		return orderInsertPblDown;
	}

	public void setOrderInsertPblDown(String orderInsertPblDown) {
		this.orderInsertPblDown = orderInsertPblDown;
	}

	public String getOrderInsertPblMixed() {
		return orderInsertPblMixed;
	}

	public void setOrderInsertPblMixed(String orderInsertPblMixed) {
		this.orderInsertPblMixed = orderInsertPblMixed;
	}

	public String getOrderInsertPdc() {
		return orderInsertPdc;
	}

	public void setOrderInsertPdc(String orderInsertPdc) {
		this.orderInsertPdc = orderInsertPdc;
	}

	public String getOrderInsertPrize() {
		return orderInsertPrize;
	}

	public void setOrderInsertPrize(String orderInsertPrize) {
		this.orderInsertPrize = orderInsertPrize;
	}

	public String getOrderInsertMix() {
		return orderInsertMix;
	}

	public void setOrderInsertMix(String orderInsertMix) {
		this.orderInsertMix = orderInsertMix;
	}

	/*
	 * 
	 * -------------- ORDER INSERT GEOTESTS
	 * 
	 */

	@Transient
	private String orderInsertOneToEachStation, orderInsertOneToAllStations, orderInsertAFrameAllGeocodes, orderInsertPblAllGeocodes, orderInsertPdcAllGeocodes;

	public String getOrderInsertOneToEachStation() {
		return orderInsertOneToEachStation;
	}

	public void setOrderInsertOneToEachStation(String orderInsertOneToEachStation) {
		this.orderInsertOneToEachStation = orderInsertOneToEachStation;
	}

	public String getOrderInsertOneToAllStations() {
		return orderInsertOneToAllStations;
	}

	public void setOrderInsertOneToAllStations(String orderInsertOneToAllStations) {
		this.orderInsertOneToAllStations = orderInsertOneToAllStations;
	}

	public String getOrderInsertAFrameAllGeocodes() {
		return orderInsertAFrameAllGeocodes;
	}

	public void setOrderInsertAFrameAllGeocodes(String orderInsertAFrameAllGeocodes) {
		this.orderInsertAFrameAllGeocodes = orderInsertAFrameAllGeocodes;
	}

	public String getOrderInsertPblAllGeocodes() {
		return orderInsertPblAllGeocodes;
	}

	public void setOrderInsertPblAllGeocodes(String orderInsertPblAllGeocodes) {
		this.orderInsertPblAllGeocodes = orderInsertPblAllGeocodes;
	}

	public String getOrderInsertPdcAllGeocodes() {
		return orderInsertPdcAllGeocodes;
	}

	public void setOrderInsertPdcAllGeocodes(String orderInsertPdcAllGeocodes) {
		this.orderInsertPdcAllGeocodes = orderInsertPdcAllGeocodes;
	}

}