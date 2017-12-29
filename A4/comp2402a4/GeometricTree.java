package comp2402a4;

import java.util.Random;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}

	public void inorderDraw() {
		assignLevels();
		GeometricTreeNode c = firstNode();
		int b = 0;
		while(c !=nil){
			c.position.x = b;
			c = nextNode(c);
			b++;
		}
	}


	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}


	/**
	 * Draw each node so that it's x-coordinate is as small
	 * as possible without intersecting any other node at the same level
	 * the same as its parent's
	 */
	public void leftistDraw() {
		assignLevels();
		Queue<GeometricTreeNode> q = new LinkedList<GeometricTreeNode>();
		GeometricTreeNode d = r;
		d.position.x = 0;
		q.add(r);
		while(!q.isEmpty()){
			GeometricTreeNode u  = q.remove();

			u.position.x = (d.position.y == u.position.y) ? d.position.x + 1 : 0;
			d = u;

			if(u.left != null){
				q.add(u.left);
			}
			if(u.right != null){
				q.add(u.right);
			}
		}
		r.position.x = 0;
	}

  Map<GeometricTreeNode, Integer> map;
	int maxX = 0;

	public void balancedDraw() {
		assignLevels();
		map = new HashMap<GeometricTreeNode, Integer>();

		//Using traverse2 from BinaryTree as framework
		GeometricTreeNode u = r, prev = nil, next;
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) next = u.left;
				else if (u.right != nil) next = u.right;
				else {
					map.put(u,(u.left!= null ? map.get(u.left) : 1) + (u.right != null ? map.get(u.right) :1 ) + 1);
					next = u.parent;
				}
			} else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else {
					map.put(u,( u.left != null ? map.get(u.left) : 1) + (u.right != null ? map.get(u.right) :1) + 1);
					next = u.parent;
				}
			} else {
				map.put(u,( u.left != null ? map.get(u.left) : 1) + (u.right != null ? map.get(u.right) :1) + 1);
				next = u.parent;
			}
			prev = u;
			u = next;
		}
		adjustChildNodes(r, 0, 0);
		maxX = 0;
	}

	public void adjustChildNodes(GeometricTreeNode u, int x, int y) {
		if (u == nil) return;

		if(x > maxX)
			maxX = x;

		u.position.x = x;
		u.position.y = y;

		if(u.left != nil && u.right == nil){ //only left has children
			this.adjustChildNodes(u.left, maxX+1, y);
		}
		else if(u.left != nil && u.right != nil){ //has children on both sides
			if(map.get(u.left) > map.get(u.right)){
				this.adjustChildNodes(u.right, x, y+1);
				this.adjustChildNodes(u.left, maxX+1, y);
			}
			else{
				this.adjustChildNodes(u.left, x, y+1);
				this.adjustChildNodes(u.right, maxX+1, y);
			}
		}
		else{ //only right has children
			this.adjustChildNodes(u.right, maxX+1, y);
		}
	}

	protected void assignLevels() {
		assignLevels(r, 0);
	}

	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}

	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}

}
