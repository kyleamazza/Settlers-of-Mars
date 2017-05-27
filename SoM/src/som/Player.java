/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

/**
 *
 * @author makogenq
 */
public class Player {
	final int VICTORY_POINT_MAX = 10;

	Integer diceRoll;

	private TradePack tradePack = new TradePack(this);

	Pane pnPlayerInfo = new Pane();
	Arc victoryPointGauge = new Arc();

	int[] resources;
	ResourceManager resourceManager = new ResourceManager();
	private int victoryPoints;

	Color playerColor;
	String nickname;
	PlayerAssets assets;

	Player() {

		assets = new PlayerAssets();
		resources = new int[] { 0, 0, 0, 0, 0 };
		victoryPoints = 0;

	}

	Player(String name, Color playerColor) {
		assets = new PlayerAssets();
		nickname = name;
		this.playerColor = playerColor;
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	Player(String name, int[] resources, Color playerColor) {
		this.nickname = name;
		this.resources = resources;
		victoryPoints = 0;
		assets = new PlayerAssets();
		this.playerColor = playerColor;
	}

	public void setVictoryPoints(int value) {
		victoryPoints = value;
		victoryPointGauge.setLength(((double) value / (double) VICTORY_POINT_MAX) * 360); // 3.6
																							// is
																							// 360
																							// divided
																							// by
																							// the
																							// 100
																							// for
																							// the
																							// 100
																							// we
																							// would
																							// have
																							// multiplied
																							// the
																							// value/vpMax
																							// to
																							// get
																							// a
																							// percentage.
		System.out.println(pnPlayerInfo.getWidth());
	}

	public void build(String assetName) {
		if (assetName.equals("SETTLEMENT"))
			;
		else if (assetName.equals("ROAD"))
			;
		else if (assetName.equals("CITY"))
			;
	}

	public void buildInitial() {
		this.build("SETTLEMENT");
		this.build("ROAD");
	}

	public void buy() {
		// resources.bankDrawResource("SOY", 10);
		// resources.printResourceList();
	}

	// Trade to another player with resources
	public void trade(Player p, String giveResourceName, int amountGive, String recieveResourceName,
			int amountRecieve) {
		System.out.println("Before Trade:");
		System.out.println("YOU:");
		System.out.println(resourceManager);
		System.out.println();
		System.out.println("Player:");
		System.out.println(p.resourceManager);
		System.out.println("------------------");

		resourceManager.give(giveResourceName, amountGive);
		p.resourceManager.recieve(giveResourceName, amountGive);
		p.resourceManager.give(recieveResourceName, amountRecieve);
		resourceManager.recieve(recieveResourceName, amountRecieve);

		System.out.println("After Trade:");
		System.out.println("YOU:");
		System.out.println(resourceManager);
		System.out.println();
		System.out.println("Player:");
		System.out.println(p.resourceManager);
		System.out.println("------------------");
	}

	public static void driver() {
		Player p1 = new Player();
		Player p2 = new Player();
		p1.trade(p2, "SOY", 4, "STEEL", 5);
	}

	int getVictoryPoints() {
		return victoryPoints;
	}

	public TradePack getTradePack() {
		return tradePack;
	}

	public void setTradePack(TradePack tradePack) {
		this.tradePack = tradePack;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int[] getResources() {
		return resources;
	}

	public void setResources(int[] resources) {
		this.resources = resources;
	}

	public void addResource(int resourceType, int qty) {
		this.resources[resourceType] += qty;
	}

	public void addResources(int[] resources) {
		for (int i = 0; i < this.resources.length; i++) {
			this.resources[i] += resources[i];
		}
	}

	public int[] removeResources(int[] resources) {
		for (int i = 0; i < this.resources.length; i++) {
			this.resources[i] -= resources[i];
		}
		return resources;
	}

	public void setResource(int index, int value) {
		this.resources[index] = value;
	}

	public int countResources() {
		int counter = 0;

		for (int i = 0; i < resources.length - 1; i++) {
			counter += resources[i];
		}
		return counter;
	}

	public void setDiceRoll(Integer rollDice) {
		this.diceRoll = rollDice;
	}

	public Integer getDiceRoll() {
		return this.diceRoll;
	}

	public boolean hasLargestArmy() {
		return (GameScreenController.getPlayerWithLargestArmy() == this);
	}

	public boolean hasLongestRoad() {
		return (GameScreenController.getPlayerWithLongestRoad() == this);
	}

	@Override
	// in progress
	public String toString() {
		return "Name: " + this.nickname + "\nVP: " + this.getVictoryPoints();
	}

	Color getPlayerColor() {
		return playerColor;
	}
}
