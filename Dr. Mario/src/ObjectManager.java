
import java.awt.Graphics;
import java.util.ArrayList;

//import game.LeagueInvaders;

public class ObjectManager {
	ArrayList<Shape> objects1;
	ArrayList<Shape> objects2;
	ArrayList<Shape> objects3;
	ArrayList<Pill> pills1;
	ArrayList<Pill> pills2;
	ArrayList<Pill> pills3;
	ArrayList<Virus> viruses;
	Pill pill2 = null;
	Pill pill = null;
	Virus virus = null;

	public int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public Pill movingPill;

	public ObjectManager() {
		objects1 = new ArrayList<Shape>();
		pills1 = new ArrayList<Pill>();
		viruses = new ArrayList<Virus>();
	}

	public void addObject(Shape o, int index) {
		if (index == 1) {
			objects1.add(o);
		}
	}

	public void addPills(int index) {
		if (!checkForFallingPills()) {
			pills1.add(new Pill(450, 192, 32, 32));
		}
	}
	
	public void addVirus(Virus v){
		viruses.add(v);
	}

	private boolean checkForFallingPills() {
		for (Pill p : pills1) {
			if (p.isPillFalling) {
				return true;
			}
		}
		return false;
	}

	public void update() {
		for (int i = 0; i < objects1.size(); i++) {
			Shape o = objects1.get(i);
			o.update();
		}
		for (int j = 0; j < pills1.size(); j++){
			Pill p = pills1.get(j);
			p.update();
		}
		for (int j = 0; j < viruses.size(); j++){
			Virus v = viruses.get(j);
			v.update();
		}
		for(Pill p : pills1){
			p.update();
		}
		
		purgeobjects1();
	}

	public void draw(Graphics g, int index) {
//		if (index == 1) {
//			for (int i = 0; i < objects1.size(); i++) {
//				Shape o = objects1.get(i);
//				o.render(g);
//				// o.renderAsImage(g);
//			}
//			for (int i = 0; i < pills1.size(); i++) {
//				Pill p = pills1.get(i);
//				p.render(g);
//			}
//		} else if (index == 2) {
//			for (int i = 0; i < objects1.size(); i++) {
//				Shape o = objects1.get(i);
//				o.render(g);
//				// o.renderAsImage(g);
//			}
//			for (int i = 0; i < pills1.size(); i++) {
//				Pill p = pills1.get(i);
//				p.render(g);
//			}
//		}
		for(Shape s : objects1){
			s.render(g);
		}
		
		for(Pill p : pills1){
			p.render(g);
		}
		
		for(Virus v : viruses){
			v.render(g);
		}
	}

	private void purgeobjects1() {
//		for (int i = 0; i < objects1.size(); i++) {
//			if (!objects1.get(i).isAlive) {
//				objects1.remove(i);
//			}
//		}
	}

	// public void manageEnemies(){
	// if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	// addObject(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50,
	// 50));
	// enemyTimer = System.currentTimeMillis();
	// }
	// }

	// public void checkCollision() {
	// for (int i = 0; i < objects1.size(); i++) {
	// for (int j = i + 1; j < objects1.size(); j++) {
	// Shape o1 = objects1.get(i);
	// Shape o2 = objects1.get(j);
	//
	// if(o1.collisionBox.intersects(o2.collisionBox)){
	// if((o1 instanceof Alien && o2 instanceof Projectile) ||
	// (o2 instanceof Alien && o1 instanceof Projectile)){
	// score++;
	// System.out.println(score);
	// o1.isAlive = false;
	// o2.isAlive = false;
	// }
	// else if((o1 instanceof Alien && o2 instanceof Rocketship) ||
	// (o2 instanceof Alien && o1 instanceof Rocketship)){
	// o1.isAlive = false;
	// o2.isAlive = false;
	// }
	//
	// }
	// }
	// }
	// }

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects1.clear();
	}

	// public void checkOnClick(int x, int y, boolean onClick){
	// for (int i = 0; i < objects1.size(); i++) {
	// Shape o = objects1.get(i);
	// if(o.collisionBox.inside(x, y) && onClick){
	// if(o instanceof QuitButton){
	// System.out.println("Hi.");
	// speak("Lol, noob get rekt.");
	// System.exit(0);
	// }
	// }
	// }
	// }

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pill getPill() {
		if (pills1.size() > 0) {
			for (int i = pills1.size() - 1; i >= 0; i--) {
				Shape pill = pills1.get(i);
				if (pill instanceof Pill) {
					return (Pill) pill;
				}
			}
		}
		return null;
	}

	boolean isPillFalling() {
		for (Pill o : pills1) {
			if (o.moving) {
				return true;
			}
		}
		return false;
	}

	void managePillCollision() {

		for (int i = 0; i < pills1.size(); i++) {
			for (int j = 0; j < pills1.size() - 1; j++) {
				Pill p = pills1.get(i);
				Pill p2 = pills1.get(j);
				if (p != movingPill) {
					if (p.collisionBox.intersects(p2.collisionBox)) {
						System.out.println("sdfghjkl;");
						p.isPillFalling = false;
						p2.isPillFalling = false;
					}
				}
			}
		}
		// System.out.println("Moving: " + movingPill.moving);
	}

	void managePillHalfCollision() {
		for (Shape p : objects1) {
			if (p instanceof PillHalf) {
				// if(p.collisionBox.intersects(p)){}
			}
		}
	}
	
	public Virus getVirus(){
		if (viruses.size() > 0) {
			for (int i = viruses.size() - 1; i >= 0; i--) {
				Shape virus = viruses.get(i);
				if (virus instanceof Virus) {
					return (Virus) virus;
				}
			}
		}
		return null;
	}
	
	public void manageVirusCollision(){
		for(int i = 0; i < viruses.size(); i++){
			virus = viruses.get(i);
			for(int j = 0; j < pills1.size(); j++){
				pill = pills1.get(j);
				if(virus.hitBox.intersects(pill.collisionBox)){
					viruses.remove(virus);
					virus.hitBox.setBounds(0,0,0,0);
					pill.isPillFalling = false;
					score+=1;
				}
				
			}
		}
		
		
	}
	
	public void removeAllPills(){
	for(int i = 0; i < pills1.size(); i++){
		Pill pill = pills1.get(i);
		pills1.remove(pill);
	}	
	
	}
	
}
