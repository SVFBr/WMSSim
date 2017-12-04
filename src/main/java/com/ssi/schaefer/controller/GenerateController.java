package com.ssi.schaefer.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssi.schaefer.entities.DatModel;
import com.ssi.schaefer.yanbal.article.insert.WebSenderArticleInsert;
import com.ssi.schaefer.yanbal.barcode.insert.WebSenderBarcodeInsert;
import com.ssi.schaefer.yanbal.location.insert.WebSenderLocationInsert;
import com.ssi.schaefer.yanbal.order.insert.WebSenderOrderInsert;
import com.ssi.schaefer.yanbal.order.insert.WebSenderOrderInsertDevicesTests;

@Controller
public class GenerateController {

	// --------------------------------------------------------------------
	// ARTICLES INSERT
	// --------------------------------------------------------------------
	@GetMapping("/yanbog/articles")
	public String novoArticle(Model model) {
		model.addAttribute(new DatModel());
		return "yanbog/generate-articles";
	}

	@PostMapping("/yanbog/articles")
	public String gerarArticle(int articleInsertAFrame, int articleInsertPbl, int articleInsertPdc, String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderArticleInsert webSenderArticleInsert = new WebSenderArticleInsert();
		webSenderArticleInsert.createArticleInsert(articleInsertAFrame, articleInsertPbl, articleInsertPdc, wamasHostIpRequested);
		return "redirect:/yanbog/articles";
	}

	// --------------------------------------------------------------------
	// BARCODE
	// --------------------------------------------------------------------
	@GetMapping("/yanbog/barcodes")
	public String novoBarcode(Model model) {
		model.addAttribute(new DatModel());
		return "yanbog/generate-barcodes";
	}

	@PostMapping("/yanbog/barcodes")
	public String gerarBarcode(String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderBarcodeInsert webSenderBarcodeInsert = new WebSenderBarcodeInsert();
		webSenderBarcodeInsert.createBarcodeInsert(wamasHostIpRequested);
		return "redirect:/yanbog/barcodes";
	}

	// --------------------------------------------------------------------
	// LOCATIONS
	// --------------------------------------------------------------------
	@GetMapping("/yanbog/locations")
	public String novoLocations(Model model) {
		model.addAttribute(new DatModel());
		return "yanbog/generate-locations";
	}

	@PostMapping("/yanbog/locations")
	public String gerarLocations(String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderLocationInsert webSenderLocationInsert = new WebSenderLocationInsert();
		webSenderLocationInsert.createBarcodeInsert(wamasHostIpRequested);
		return "redirect:/yanbog/locations";
	}
	// --------------------------------------------------------------------
	// GEO 
	// --------------------------------------------------------------------
	@GetMapping("/yanbog/geo")
	public String novoGeo(Model model) {
		model.addAttribute(new DatModel());
		return "yanbog/generate-geo";
	}
	
	@PostMapping("/yanbog/geo")
	public String gerarGeo(int orderInsertAframeGeoTests, int orderInsertPblGeoTests, int orderInsertPdcGeoTests, int orderInsertEachStation, String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderOrderInsertDevicesTests webSenderOrderInsertGeoTests = new WebSenderOrderInsertDevicesTests();
		webSenderOrderInsertGeoTests.createArticleInsert(orderInsertAframeGeoTests, orderInsertPblGeoTests, orderInsertPdcGeoTests, orderInsertEachStation, wamasHostIpRequested);
		return "redirect:/yanbog/geo";
	}

	// --------------------------------------------------------------------
	// ORDERS
	// --------------------------------------------------------------------
	@GetMapping("/yanbog")
	public String novoOrders(Model model) {
		model.addAttribute(new DatModel());
		return "yanbog/generate-orders";
	}

	@PostMapping("/yanbog")
	public String gerarOrders(int orderInsertAframe, int orderInsertPblUp, int orderInsertPblDown, int orderInsertPblMixed, int orderInsertPdc, int orderInsertPrize, int orderInsertMix, String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderOrderInsert webSenderOrderInsert = new WebSenderOrderInsert();
		webSenderOrderInsert.createArticleInsert(orderInsertAframe, orderInsertPblUp, orderInsertPblDown, orderInsertPblMixed, orderInsertPdc, orderInsertPrize, orderInsertMix, wamasHostIpRequested);
		return "redirect:/yanbog";
	}

/*	// --------------------------------------------------------------------
	// GEOTESTS
	// --------------------------------------------------------------------
	@GetMapping("/yanbog/geotests")
	public String novoGeocodeTests(Model model) {
		model.addAttribute(new DatModel());
		return "/yanbog/generate-geotests";
	}

	@PostMapping("/yanbog/geotests")
	public String gerarGeocodeTests(int orderInsertAframeGeoTests, int orderInsertPblGeoTests, int orderInsertPdcGeoTests, String wamasHostIpRequested) throws IOException, ClassNotFoundException, SQLException {
		WebSenderOrderInsertGeoTests webSenderOrderInsertGeoTests = new WebSenderOrderInsertGeoTests();
		webSenderOrderInsertGeoTests.createArticleInsert(orderInsertAframeGeoTests, orderInsertPblGeoTests, orderInsertPdcGeoTests, wamasHostIpRequested);
		return "redirect:/yanbog/geotests";
	}*/
	/*
	 *
	 * ---------------- ERROR HANDLING
	 *
	 */

	// @GetMapping("/err/insert")
	// public String novoErrArticleInsert(Model model) {
	// model.addAttribute(new DatModel());
	// return "err/article-insert";
	// }
	//
	// @PostMapping("/err/insert")
	// public String gerarErrArticleInsert(Model model) throws IOException {
	// Articles art = new Articles();
	// art.articleInsert();
	// return "err/article-insert";
	// }

}
