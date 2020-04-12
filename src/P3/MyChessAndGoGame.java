package P3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import P3.Game.Game;
import P3.Player.*;
import P3.Position.Position;
import P3.Action.*;
public class MyChessAndGoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		List<String> history = new LinkedList<>();
		String gameType;
		String player_1;
		String player_2;
		while (true) {
			int i = 0;
			System.out.println("请输入游戏类型：1代表chess，2代表go");
			if (input.hasNextInt()) {
				i = input.nextInt();
			}
			if (i == 1) {
				gameType = "chess";
				input.nextLine();
				break;
			} else if (i == 2) {
				gameType = "go";
				input.nextLine();
				break;
			} else
				System.out.println("错误的输入,请输入1或2");
		}
		
		do {
			System.out.println("请输入玩家1的名字：");
			player_1 = input.nextLine();

			System.out.println("请输入玩家2的名字：");
			player_2 = input.nextLine();
			
			if(!player_1.equals(player_2)) {
				break;
			}else
				System.out.println("玩家名字不能相同");
		}while(true);

		

		Action action = Action.empty(gameType, player_1, player_2);
		action.setPlayer(player_1, player_2);
		action.setfirstHead_1();
		action.initalBoard();
		String line = null;
		Player currentPlayer = null;
		if (gameType == "chess") {
			
			do {
				chessMenu();
				if (action.getFirstHeadPlayer().getName() == player_1) {
					System.out.println("当前操作为玩家1");
					currentPlayer = new Player(player_1);
				}

				else {
					System.out.println("当前操作为玩家2");
					currentPlayer = new Player(player_2);
				}

				line = input.nextLine();
				switch (line) {
				case "1":
					System.out.println("请输入需要移动的棋子坐标 x y /x,y需要为整数[0,7]，如果输入超过或小于，输入不正确则会抛出异常");
					int x1 = input.nextInt();
					int y1 = input.nextInt();
					Position position_1 = new Position(x1,y1);
					System.out.println("请输入目标棋子坐标 x y /x,y需要为整数[0,7]，如果输入超过或小于，输入不正确则会抛出异常");
					int x2 = input.nextInt();
					int y2 = input.nextInt();
					Position position_2 = new Position(x2,y2);
					input.nextLine();
					history.add(currentPlayer.getName()+" 使"+" "+position_1.getX()+" "+position_1.getY()+" 到 "+position_2.getX()+" "+position_2.getY());
					action.movePiece(currentPlayer, x1, y1, x2, y2);
					action.changeFirstHead();
					break;
				case "2":
					System.out.println("请输入需要移动的棋子坐标 x y /x,y需要为整数[0,7]，如果输入超过或小于，输入不正确则会抛出异常");
					int x_1 = input.nextInt();
					int y_1 = input.nextInt();
					Position position_3 = new Position(x_1,y_1);
					System.out.println("请输入目标棋子坐标 x y /x,y需要为整数[0,7]，如果输入超过或小于，输入不正确则会抛出异常");
					int x_2 = input.nextInt();
					int y_2 = input.nextInt();
					Position position_4 = new Position(x_2,y_2);
					input.nextLine();
					history.add(currentPlayer.getName()+" 使"+" "+x_1+" "+y_1+" 吃 "+x_2+" "+y_2);
					Player player2 = null;
					if(currentPlayer.getName()==player_1)
						player2 = new Player(player_2);
					else
						player2 = new Player(player_1);
					action.eatPiece(currentPlayer, player2,position_3.getX(),position_3.getY(),position_4.getX(),position_4.getX());
					action.changeFirstHead();
					break;
				case "3":
					System.out.println("请输入需要查询的棋子坐标 x y /x,y需要为整数[0,7]，如果输入超过或小于，输入不正确则会抛出异常");
					int x_3 = input.nextInt();
					int y_3 = input.nextInt();
					Position position_5 = new Position(x_3,y_3);
					input.nextLine();
					history.add(currentPlayer.getName()+" 查询"+" "+position_5.getX()+" "+position_5.getY());
					String a = action.getPieceType(x_3, y_3);
					if(a==null)
						System.out.println("当前位置无子");
					else if(a=="white_rook")
						System.out.println("当前位置为白方的車");
					else if(a=="white_pawn")
						System.out.println("当前位置为白方的兵");
					else if(a=="white_knight")
						System.out.println("当前位置为白方的馬");
					else if(a=="white_bishop")
						System.out.println("当前位置为白方的象");
					else if(a=="white_king")
						System.out.println("当前位置为白方的车");
					else if(a=="white_queen")
						System.out.println("当前位置为白方的後");
					else if(a=="black_rook")
						System.out.println("当前位置为黑方的车");
					else if(a=="white_pawn")
						System.out.println("当前位置为黑方的卒");
					else if(a=="black_knight")
						System.out.println("当前位置为黑方的马");
					else if(a=="black_bishop")
						System.out.println("当前位置为黑方的相");
					else if(a=="black_king")
						System.out.println("当前位置为黑方的王");
					else if(a=="black_queen")
						System.out.println("当前位置为黑方的后");
					action.changeFirstHead();
					break;
				case "4":
					action.changeFirstHead();
					history.add(currentPlayer.getName()+" 跳过");
					break;
				case "5":
					int sum1 = action.calPieces(player_1);
					int sum2 = action.calPieces(player_2);
					System.out.println("玩家1的棋子数为"+sum1);
					System.out.println("玩家2的棋子数为"+sum2);
					history.add(currentPlayer.getName()+" 计算棋子总数");
					action.changeFirstHead();
					break;
				case "6":
					print(action, player_1, player_2);
					history.add(currentPlayer.getName()+" 打印棋盘");
					break;
				case "7":
					for(String his:history) {
						System.out.println(his);
					}
					System.exit(0);
					break;
				default :
					System.out.println("请重新输入");
					break;
				
				
				}
				
			} while (!line.equals("end"));
		} else if (gameType == "go") {
			do {
				goMenu();
				if (action.getFirstHeadPlayer().getName() == player_1) {
					System.out.println("当前操作为玩家1");
					currentPlayer = new Player(player_1);
				}

				else {
					System.out.println("当前操作为玩家2");
					currentPlayer = new Player(player_2);
				}
				
				line = input.nextLine();

				switch (line) {
				case "1":
					System.out.println("请输入需要放置的棋子坐标 x y /x,y需要为整数[0,18]，如果输入超过或小于，输入不正确则会抛出异常");
					
					int x2 = input.nextInt();
					int y2 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" 放置 "+x2+" "+y2);
					action.placePiece(currentPlayer, x2, y2);
					action.changeFirstHead();
					break;
				case "2":
					System.out.println("请输入需要提子的棋子坐标 x y /x,y需要为整数[0,18]，如果输入超过或小于，输入不正确则会抛出异常");
					int x_1 = input.nextInt();
					int y_1 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" 提子"+x_1+" "+y_1);
					action.removePiece(currentPlayer, x_1, y_1);
					action.changeFirstHead();
					break;
				case "3":
					System.out.println("请输入需要查询的棋子坐标 x y /x,y需要为整数[0,18]，如果输入超过或小于，输入不正确则会抛出异常");
					int x_3 = input.nextInt();
					int y_3 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" 查询"+" "+x_3+" "+y_3);
					String a = action.getPieceType(x_3, y_3);
					if(a==null)
						System.out.println("当前位置无子");
					else if(a==player_2)
						System.out.println("当前位置的子属于黑方");
					else if(a==player_1)
						System.out.println("当前位置的子属于白方");
					action.changeFirstHead();
					break;
				case "4":
					action.changeFirstHead();
					history.add(currentPlayer.getName()+" 跳过");
					break;
				case "5":
					int sum1 = action.calPieces(player_1);
					int sum2 = action.calPieces(player_2);
					System.out.println("玩家1的棋子数为"+sum1);
					System.out.println("玩家2的棋子数为"+sum2);
					history.add(currentPlayer.getName()+" calculate sum of Pieces");
					action.changeFirstHead();
					break;
				case "6":
					print(action, player_1, player_2);
					history.add(currentPlayer.getName()+" print the board");
					break;
				case "7":
					for(String his:history) {
						System.out.println(his);
					}
					System.exit(0);
					
					break;
				default :
					System.out.println("请重新输入");
					break;
				}
				
				
			} while (!line.equals("end"));
		}
	}

	public static void chessMenu() {
		System.out.println("******************");
		System.out.println("玩家1为白方在下，玩家2为黑方在上");
		System.out.println("玩法提示");
		System.out.println("移子：1");
		System.out.println("吃子：2");
		System.out.println("查询：3");
		System.out.println("跳过：4");
		System.out.println("计算棋子数：5");
		System.out.println("打印棋盘：6");
		System.out.println("结束游戏：7");
		System.out.println("******************");
		System.out.println("请输入命令");

	}

	public static void goMenu() {
		System.out.println("******************");
		System.out.println("玩法提示");
		System.out.println("落子：1");
		System.out.println("提子：2");
		System.out.println("查询：3");
		System.out.println("跳过：4");
		System.out.println("计算棋子数：5");
		System.out.println("打印棋盘：6");
		System.out.println("结束游戏：7");
		System.out.println("******************");
		System.out.println("请输入命令");
	}

	public static void print(Action action, String player_1, String player_2) {
		
			
		for (int j = 0; j < action.getSize(); j++) {
			
			for (int i = 0; i < action.getSize(); i++) {

				if (action.getGameType() == "go") {
					if (action.getPieceType(i, action.getSize() - 1 - j) == player_1) {
						System.out.print("白");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == player_2) {
						System.out.print("黑");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == null) {
						System.out.print("　");
					}
				}

				if (action.getGameType() == "chess") {
					if (action.getPieceType(i, action.getSize() - 1 - j) == "black_pawn") {
						System.out.print("卒");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_king") {
						System.out.print("将");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_knight") {
						System.out.print("马");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_queen") {
						System.out.print("后");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_bishop") {
						System.out.print("相");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_rook") {
						System.out.print("车");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_pawn") {
						System.out.print("兵");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_king") {
						System.out.print("帅");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_knight") {
						System.out.print("馬");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_queen") {
						System.out.print("後");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_bishop") {
						System.out.print("象");
					} else if (action.getPieceType(i,action.getSize() - 1 - j) == "white_rook") {
						System.out.print("車");
					}else
						System.out.print("　");
				}

			}
			System.out.println();
		}
	}
}
