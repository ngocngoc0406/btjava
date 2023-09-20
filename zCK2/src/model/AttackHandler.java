package model;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class AttackHandler extends Thread{
	private Receiver receiver1, receiver2;
	private Server2 server;
	private String turnMessage;
	
	public AttackHandler(Server2 server) {
		super();
		this.server = server;
		this.receiver1 = server.getReceiver1();
		this.receiver2 = server.getReceiver2();
		this.turnMessage = "=============================================================================\nTurn: ";
	}
	
	public void run() {
		int turn = 1;
		receiver1.sendMessageToClient(turnMessage+turn);
		receiver2.sendMessageToClient(turnMessage+turn);
		turn++;
		long r1HP = -400;
		long r2HP = -400;
		while(true) {
			String message1 = receiver1.getAttackCommand();
			String message2 = receiver2.getAttackCommand();
			if (message1 != null && message2 != null) {
				JSONObject r1 = (JSONObject) JSONValue.parse(message1);
				JSONObject r2 = (JSONObject) JSONValue.parse(message2);
				System.out.println("2 attack found");
				if(r1HP == -400) {
					System.out.println("get1");
					r1HP = (long) r1.get("HP");
				}
				if(r2HP == -400) {
					System.out.println("get2");
					r2HP = (long) r2.get("HP");
				}
				
				if((long)r1.get("SPD") >= (long)r2.get("SPD")) {
					String attackDescription = r1.get("pkmName")+" used "+r1.get("name");
					receiver1.sendMessageToClient(attackDescription);
					receiver2.sendMessageToClient(attackDescription);
					long categoryStatAttack, categoryStatDefence;
					if(((String) r1.get("category")).equals("physical")) {
						categoryStatAttack = ((long)r1.get("ATK"));
						categoryStatDefence = (long)r2.get("DEF");
					} else if(((String) r1.get("category")).equals("special")) {
						categoryStatAttack = (long)r1.get("SPATK");
						categoryStatDefence = (long)r1.get("SPDEF");
					} else {
						categoryStatAttack = 0;
						categoryStatDefence = 1;
					}
					double damage = (2+((2*50+2)/5*categoryStatAttack/categoryStatDefence*(long)r1.get("dmg"))/50);
					int real = realDMG((int)damage,(String)r1.get("type"),(String)r2.get("pkmTypes1"));
					real = realDMG(real,(String)r1.get("type"),(String)r2.get("pkmTypes2"));
					r2HP -= real;
					System.out.println("r2 " + (r2HP - real));
					if(r2HP > 0) {
						String attackDescription1 = r2.get("pkmName")+" used "+r2.get("name");
						receiver1.sendMessageToClient(attackDescription1);
						receiver2.sendMessageToClient(attackDescription1);
						long categoryStatAttack1, categoryStatDefence1;
						if(((String) r2.get("category")).equals("physical")) {
							categoryStatAttack1 = ((long)r2.get("ATK"));
							categoryStatDefence1 = (long)r1.get("DEF");
						} else if(((String) r2.get("category")).equals("special")) {
							categoryStatAttack1 = (long)r2.get("SPATK");
							categoryStatDefence1 = (long)r2.get("SPDEF");
						} else {
							categoryStatAttack1 = 0;
							categoryStatDefence1 = 1;
						}
						double damage1 = (2+((2*50+2)/5*categoryStatAttack1/categoryStatDefence1*(long)r2.get("dmg"))/50);
						int real1 = realDMG((int)damage1,(String)r2.get("type"),(String)r1.get("pkmTypes1"));
						real1 = realDMG(real1,(String)r2.get("type"),(String)r1.get("pkmTypes2"));
						
						r1HP -= real1;
						System.out.println("r1 " + (r1HP - real1));
					}
					receiver1.sendHPToClient("{\"self\":"+r2HP+"}");
					receiver1.sendHPToClient("{\"foe\":"+r1HP+"}");
					receiver2.sendHPToClient("{\"foe\":"+r2HP+"}");
					receiver2.sendHPToClient("{\"self\":"+r1HP+"}");
				} else {
					String attackDescription1 = r2.get("pkmName")+" used "+r2.get("name");
					receiver1.sendMessageToClient(attackDescription1);
					receiver2.sendMessageToClient(attackDescription1);
					long categoryStatAttack1, categoryStatDefence1;
					if(((String) r2.get("category")).equals("physical")) {
						categoryStatAttack1 = ((long)r2.get("ATK"));
						categoryStatDefence1 = (long)r1.get("DEF");
					} else if(((String) r2.get("category")).equals("special")) {
						categoryStatAttack1 = (long)r2.get("SPATK");
						categoryStatDefence1 = (long)r2.get("SPDEF");
					} else {
						categoryStatAttack1 = 0;
						categoryStatDefence1 = 1;
					}
					double damage1 = (2+((2*50+2)/5*categoryStatAttack1/categoryStatDefence1*(long)r2.get("dmg"))/50);
					int real1 = realDMG((int)damage1,(String)r2.get("type"),(String)r1.get("pkmTypes1"));
					real1 = realDMG(real1,(String)r2.get("type"),(String)r1.get("pkmTypes2"));
					
					r1HP -= real1;
					System.out.println("r1 " + (r1HP - real1));
					
					if(r2HP > 0) {						
						String attackDescription = r1.get("pkmName")+" used "+r1.get("name");
						receiver1.sendMessageToClient(attackDescription);
						receiver2.sendMessageToClient(attackDescription);
						long categoryStatAttack, categoryStatDefence;
						if(((String) r1.get("category")).equals("physical")) {
							categoryStatAttack = ((long)r1.get("ATK"));
							categoryStatDefence = (long)r2.get("DEF");
						} else if(((String) r1.get("category")).equals("special")) {
							categoryStatAttack = (long)r1.get("SPATK");
							categoryStatDefence = (long)r1.get("SPDEF");
						} else {
							categoryStatAttack = 0;
							categoryStatDefence = 1;
						}
						double damage = (2+((2*50+2)/5*categoryStatAttack/categoryStatDefence*(long)r1.get("dmg"))/50);
						int real = realDMG((int)damage,(String)r1.get("type"),(String)r2.get("pkmTypes1"));
						real = realDMG(real,(String)r1.get("type"),(String)r2.get("pkmTypes2"));
						r2HP -= real;
						}
					receiver1.sendHPToClient("{\"self\":"+r1HP+"}");
					receiver1.sendHPToClient("{\"foe\":"+r2HP+"}");
					receiver2.sendHPToClient("{\"foe\":"+r1HP+"}");
					receiver2.sendHPToClient("{\"self\":"+r2HP+"}");
				}
				receiver1.setAttackCommand(null);
				receiver2.setAttackCommand(null);
				receiver1.sendMessageToClient(turnMessage+turn);
				receiver2.sendMessageToClient(turnMessage+turn);
				turn++;	
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public int realDMG(int n, String typeCause, String typeTake) {
		if(typeCause.equalsIgnoreCase("normal") && typeTake.equalsIgnoreCase("rock")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("normal") && typeTake.equalsIgnoreCase("ghost")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("normal") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("water")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("rock")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("dragon")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("grass")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("ice")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("bug")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fire") && typeTake.equalsIgnoreCase("steel")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("water")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("grass")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("dragon")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("fire")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("ground")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("water") && typeTake.equalsIgnoreCase("rock")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("electric")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("grass")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("dragon")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("ground")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("water")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("electric") && typeTake.equalsIgnoreCase("fly")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("grass")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("poison")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("flying")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("bug")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("dragon")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("water")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("ground")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("grass") && typeTake.equalsIgnoreCase("rock")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("water")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("ice")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("grass")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("ground")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("flying")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ice") && typeTake.equalsIgnoreCase("dragon")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("poison")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("flying")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("psychic")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("bug")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("fairy")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("normal")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("ice")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("rock")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("dark")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fighting") && typeTake.equalsIgnoreCase("steel")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("poison")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("ground")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("rock")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("ghost")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("steel")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("grass")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("poison") && typeTake.equalsIgnoreCase("fairy")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("flying")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("grass")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("bug")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("fire")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("electric")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("poison")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("rock")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ground") && typeTake.equalsIgnoreCase("steel")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("electric")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("rock")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("grass")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("fighting")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("flying") && typeTake.equalsIgnoreCase("bug")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("psychic") && typeTake.equalsIgnoreCase("psychic")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("psychic") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("psychic") && typeTake.equalsIgnoreCase("dark")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("psychic") && typeTake.equalsIgnoreCase("fighting")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("psychic") && typeTake.equalsIgnoreCase("poison")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("fighting")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("poison")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("flying")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("fairy")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("grass")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("psychic")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("bug") && typeTake.equalsIgnoreCase("dark")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("fighting")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("ground")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("fire")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("ice")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("flying")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("rock") && typeTake.equalsIgnoreCase("bug")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ghost") && typeTake.equalsIgnoreCase("dark")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("ghost") && typeTake.equalsIgnoreCase("normal")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("ghost") && typeTake.equalsIgnoreCase("psychic")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("ghost") && typeTake.equalsIgnoreCase("ghost")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("dragon") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("dragon") && typeTake.equalsIgnoreCase("dragon")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("dragon") && typeTake.equalsIgnoreCase("fairy")) {
			return 0;
		} else if(typeCause.equalsIgnoreCase("dark") && typeTake.equalsIgnoreCase("fighting")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("dark") && typeTake.equalsIgnoreCase("dark")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("dark") && typeTake.equalsIgnoreCase("fairy")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("dark") && typeTake.equalsIgnoreCase("psychic")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("dark") && typeTake.equalsIgnoreCase("ghost")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("water")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("electric")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("ice")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("rock")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("steel") && typeTake.equalsIgnoreCase("fairy")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("fire")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("poison")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("steel")) {
			return n/2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("fighting")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("dark")) {
			return n*2;
		} else if(typeCause.equalsIgnoreCase("fairy") && typeTake.equalsIgnoreCase("dragon")) {
			return n*2;
		}
		else return n;
		
	}
	
}
