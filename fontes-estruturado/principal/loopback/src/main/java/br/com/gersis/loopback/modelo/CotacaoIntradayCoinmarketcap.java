package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class CotacaoIntradayCoinmarketcap extends Model {


	private String ticker;
	private String dataHora;
	private int diaNum;
	private double numMarketPair;
	private double circulationSupply;
	private double totalSupply;
	private double cmcRank;
	private double price;
	private double volume24h;
	private double marketCap;
	private double marketCapDominance;
	private double fullyDilutedMarketCap;
	// Relacionamentos 1
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("dataHora", dataHora);
			obj.put("diaNum", diaNum);
			obj.put("numMarketPair", numMarketPair);
			obj.put("circulationSupply", circulationSupply);
			obj.put("totalSupply", totalSupply);
			obj.put("cmcRank", cmcRank);
			obj.put("price", price);
			obj.put("volume24h", volume24h);
			obj.put("marketCap", marketCap);
			obj.put("marketCapDominance", marketCapDominance);
			obj.put("fullyDilutedMarketCap", fullyDilutedMarketCap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setDataHora(String valor) { 
		this.dataHora = valor;
	}
	public String getDataHora() { 
		return this.dataHora;
	}
	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setNumMarketPair(double valor) { 
		this.numMarketPair = valor;
	}
	public double getNumMarketPair() { 
		return this.numMarketPair;
	}
	public void setCirculationSupply(double valor) { 
		this.circulationSupply = valor;
	}
	public double getCirculationSupply() { 
		return this.circulationSupply;
	}
	public void setTotalSupply(double valor) { 
		this.totalSupply = valor;
	}
	public double getTotalSupply() { 
		return this.totalSupply;
	}
	public void setCmcRank(double valor) { 
		this.cmcRank = valor;
	}
	public double getCmcRank() { 
		return this.cmcRank;
	}
	public void setPrice(double valor) { 
		this.price = valor;
	}
	public double getPrice() { 
		return this.price;
	}
	public void setVolume24h(double valor) { 
		this.volume24h = valor;
	}
	public double getVolume24h() { 
		return this.volume24h;
	}
	public void setMarketCap(double valor) { 
		this.marketCap = valor;
	}
	public double getMarketCap() { 
		return this.marketCap;
	}
	public void setMarketCapDominance(double valor) { 
		this.marketCapDominance = valor;
	}
	public double getMarketCapDominance() { 
		return this.marketCapDominance;
	}
	public void setFullyDilutedMarketCap(double valor) { 
		this.fullyDilutedMarketCap = valor;
	}
	public double getFullyDilutedMarketCap() { 
		return this.fullyDilutedMarketCap;
	}

}
