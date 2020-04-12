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
			System.out.println("��������Ϸ���ͣ�1����chess��2����go");
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
				System.out.println("���������,������1��2");
		}
		
		do {
			System.out.println("���������1�����֣�");
			player_1 = input.nextLine();

			System.out.println("���������2�����֣�");
			player_2 = input.nextLine();
			
			if(!player_1.equals(player_2)) {
				break;
			}else
				System.out.println("������ֲ�����ͬ");
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
					System.out.println("��ǰ����Ϊ���1");
					currentPlayer = new Player(player_1);
				}

				else {
					System.out.println("��ǰ����Ϊ���2");
					currentPlayer = new Player(player_2);
				}

				line = input.nextLine();
				switch (line) {
				case "1":
					System.out.println("��������Ҫ�ƶ����������� x y /x,y��ҪΪ����[0,7]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x1 = input.nextInt();
					int y1 = input.nextInt();
					Position position_1 = new Position(x1,y1);
					System.out.println("������Ŀ���������� x y /x,y��ҪΪ����[0,7]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x2 = input.nextInt();
					int y2 = input.nextInt();
					Position position_2 = new Position(x2,y2);
					input.nextLine();
					history.add(currentPlayer.getName()+" ʹ"+" "+position_1.getX()+" "+position_1.getY()+" �� "+position_2.getX()+" "+position_2.getY());
					action.movePiece(currentPlayer, x1, y1, x2, y2);
					action.changeFirstHead();
					break;
				case "2":
					System.out.println("��������Ҫ�ƶ����������� x y /x,y��ҪΪ����[0,7]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x_1 = input.nextInt();
					int y_1 = input.nextInt();
					Position position_3 = new Position(x_1,y_1);
					System.out.println("������Ŀ���������� x y /x,y��ҪΪ����[0,7]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x_2 = input.nextInt();
					int y_2 = input.nextInt();
					Position position_4 = new Position(x_2,y_2);
					input.nextLine();
					history.add(currentPlayer.getName()+" ʹ"+" "+x_1+" "+y_1+" �� "+x_2+" "+y_2);
					Player player2 = null;
					if(currentPlayer.getName()==player_1)
						player2 = new Player(player_2);
					else
						player2 = new Player(player_1);
					action.eatPiece(currentPlayer, player2,position_3.getX(),position_3.getY(),position_4.getX(),position_4.getX());
					action.changeFirstHead();
					break;
				case "3":
					System.out.println("��������Ҫ��ѯ���������� x y /x,y��ҪΪ����[0,7]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x_3 = input.nextInt();
					int y_3 = input.nextInt();
					Position position_5 = new Position(x_3,y_3);
					input.nextLine();
					history.add(currentPlayer.getName()+" ��ѯ"+" "+position_5.getX()+" "+position_5.getY());
					String a = action.getPieceType(x_3, y_3);
					if(a==null)
						System.out.println("��ǰλ������");
					else if(a=="white_rook")
						System.out.println("��ǰλ��Ϊ�׷���܇");
					else if(a=="white_pawn")
						System.out.println("��ǰλ��Ϊ�׷��ı�");
					else if(a=="white_knight")
						System.out.println("��ǰλ��Ϊ�׷����R");
					else if(a=="white_bishop")
						System.out.println("��ǰλ��Ϊ�׷�����");
					else if(a=="white_king")
						System.out.println("��ǰλ��Ϊ�׷��ĳ�");
					else if(a=="white_queen")
						System.out.println("��ǰλ��Ϊ�׷�����");
					else if(a=="black_rook")
						System.out.println("��ǰλ��Ϊ�ڷ��ĳ�");
					else if(a=="white_pawn")
						System.out.println("��ǰλ��Ϊ�ڷ�����");
					else if(a=="black_knight")
						System.out.println("��ǰλ��Ϊ�ڷ�����");
					else if(a=="black_bishop")
						System.out.println("��ǰλ��Ϊ�ڷ�����");
					else if(a=="black_king")
						System.out.println("��ǰλ��Ϊ�ڷ�����");
					else if(a=="black_queen")
						System.out.println("��ǰλ��Ϊ�ڷ��ĺ�");
					action.changeFirstHead();
					break;
				case "4":
					action.changeFirstHead();
					history.add(currentPlayer.getName()+" ����");
					break;
				case "5":
					int sum1 = action.calPieces(player_1);
					int sum2 = action.calPieces(player_2);
					System.out.println("���1��������Ϊ"+sum1);
					System.out.println("���2��������Ϊ"+sum2);
					history.add(currentPlayer.getName()+" ������������");
					action.changeFirstHead();
					break;
				case "6":
					print(action, player_1, player_2);
					history.add(currentPlayer.getName()+" ��ӡ����");
					break;
				case "7":
					for(String his:history) {
						System.out.println(his);
					}
					System.exit(0);
					break;
				default :
					System.out.println("����������");
					break;
				
				
				}
				
			} while (!line.equals("end"));
		} else if (gameType == "go") {
			do {
				goMenu();
				if (action.getFirstHeadPlayer().getName() == player_1) {
					System.out.println("��ǰ����Ϊ���1");
					currentPlayer = new Player(player_1);
				}

				else {
					System.out.println("��ǰ����Ϊ���2");
					currentPlayer = new Player(player_2);
				}
				
				line = input.nextLine();

				switch (line) {
				case "1":
					System.out.println("��������Ҫ���õ��������� x y /x,y��ҪΪ����[0,18]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					
					int x2 = input.nextInt();
					int y2 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" ���� "+x2+" "+y2);
					action.placePiece(currentPlayer, x2, y2);
					action.changeFirstHead();
					break;
				case "2":
					System.out.println("��������Ҫ���ӵ��������� x y /x,y��ҪΪ����[0,18]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x_1 = input.nextInt();
					int y_1 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" ����"+x_1+" "+y_1);
					action.removePiece(currentPlayer, x_1, y_1);
					action.changeFirstHead();
					break;
				case "3":
					System.out.println("��������Ҫ��ѯ���������� x y /x,y��ҪΪ����[0,18]��������볬����С�ڣ����벻��ȷ����׳��쳣");
					int x_3 = input.nextInt();
					int y_3 = input.nextInt();
					input.nextLine();
					history.add(currentPlayer.getName()+" ��ѯ"+" "+x_3+" "+y_3);
					String a = action.getPieceType(x_3, y_3);
					if(a==null)
						System.out.println("��ǰλ������");
					else if(a==player_2)
						System.out.println("��ǰλ�õ������ںڷ�");
					else if(a==player_1)
						System.out.println("��ǰλ�õ������ڰ׷�");
					action.changeFirstHead();
					break;
				case "4":
					action.changeFirstHead();
					history.add(currentPlayer.getName()+" ����");
					break;
				case "5":
					int sum1 = action.calPieces(player_1);
					int sum2 = action.calPieces(player_2);
					System.out.println("���1��������Ϊ"+sum1);
					System.out.println("���2��������Ϊ"+sum2);
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
					System.out.println("����������");
					break;
				}
				
				
			} while (!line.equals("end"));
		}
	}

	public static void chessMenu() {
		System.out.println("******************");
		System.out.println("���1Ϊ�׷����£����2Ϊ�ڷ�����");
		System.out.println("�淨��ʾ");
		System.out.println("���ӣ�1");
		System.out.println("���ӣ�2");
		System.out.println("��ѯ��3");
		System.out.println("������4");
		System.out.println("������������5");
		System.out.println("��ӡ���̣�6");
		System.out.println("������Ϸ��7");
		System.out.println("******************");
		System.out.println("����������");

	}

	public static void goMenu() {
		System.out.println("******************");
		System.out.println("�淨��ʾ");
		System.out.println("���ӣ�1");
		System.out.println("���ӣ�2");
		System.out.println("��ѯ��3");
		System.out.println("������4");
		System.out.println("������������5");
		System.out.println("��ӡ���̣�6");
		System.out.println("������Ϸ��7");
		System.out.println("******************");
		System.out.println("����������");
	}

	public static void print(Action action, String player_1, String player_2) {
		
			
		for (int j = 0; j < action.getSize(); j++) {
			
			for (int i = 0; i < action.getSize(); i++) {

				if (action.getGameType() == "go") {
					if (action.getPieceType(i, action.getSize() - 1 - j) == player_1) {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == player_2) {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == null) {
						System.out.print("��");
					}
				}

				if (action.getGameType() == "chess") {
					if (action.getPieceType(i, action.getSize() - 1 - j) == "black_pawn") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_king") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_knight") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_queen") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_bishop") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "black_rook") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_pawn") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_king") {
						System.out.print("˧");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_knight") {
						System.out.print("�R");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_queen") {
						System.out.print("��");
					} else if (action.getPieceType(i, action.getSize() - 1 - j) == "white_bishop") {
						System.out.print("��");
					} else if (action.getPieceType(i,action.getSize() - 1 - j) == "white_rook") {
						System.out.print("܇");
					}else
						System.out.print("��");
				}

			}
			System.out.println();
		}
	}
}
