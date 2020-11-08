import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	//binary tree tests (similar to those run in the original LCA(assignment 1) )
	@Test
	public void testEmptyTree() {
	DAG tree = new DAG();
			assertEquals("LCA of empty tree:", -1, tree.functionLCADAG(0, 0));
		}
	
	//binary tree test
	@Test
	public void testOneNodeTree() {
	DAG tree = new DAG();
			tree.root = new NodeDAG(1);
			assertEquals("LCA of a one node tree:", -1, tree.functionLCADAG(1, 0));
		}
	
	//binary tree test
	@Test
	public void testCommonBinaryTree() {
	//   1
	//  / \
	// 2   3
//    /\   /\
//	 4  5  6 7
	DAG tree = new DAG();
			tree.root = new NodeDAG(1);
			tree.root.left = new NodeDAG(2);
			tree.root.right = new NodeDAG(3);
			tree.root.left.left = new NodeDAG(4);
			tree.root.left.right = new NodeDAG(5);
			tree.root.right.left = new NodeDAG(6);
			tree.root.right.right = new NodeDAG(7);
			assertEquals("LCA of 1 and 2:", 1, tree.functionLCADAG(1, 2));
			assertEquals("LCA of 2 and 3:", 1, tree.functionLCADAG(2, 3));
			assertEquals("LCA of 2 and 4:", 2, tree.functionLCADAG(2, 4));
			assertEquals("LCA of 4 and 5:", 2, tree.functionLCADAG(4, 5));
			assertEquals("LCA of 6 and 7:", 3, tree.functionLCADAG(6, 7));	
		}

	//binary tree test
	@Test
	public void testNonExistentNode() {
	DAG tree = new DAG();
			tree.root = new NodeDAG(1);
			tree.root.left = new NodeDAG(2);
			tree.root.right = new NodeDAG(3);
			tree.root.left.left = new NodeDAG(4);
			tree.root.left.right = new NodeDAG(5);
			tree.root.right.left = new NodeDAG(6);
			tree.root.right.right = new NodeDAG(7);
			assertEquals("LCA of 10 and 100:", -1, tree.functionLCADAG(10, 100));
			assertEquals("LCA of 2 and 785:", -1, tree.functionLCADAG(2, 1000));
		}
	
	//binary tree test
	@Test
	public void testSameNodes(){
	DAG tree = new DAG();
			tree.root = new NodeDAG(4);
			tree.root.left = new NodeDAG(4);
			tree.root.right = new NodeDAG(4);
			tree.root.left.left = new NodeDAG(4);
			tree.root.left.right = new NodeDAG(4);
			tree.root.right.left = new NodeDAG(4);
			tree.root.right.right = new NodeDAG(4);
			assertEquals("LCA of 4 and 4: ", 4, tree.functionLCADAG(4, 4));
		}
	
	//binary tree test
	@Test 
	public void testUnbalancedTree() { 
	DAG tree = new DAG();
			tree.root = new NodeDAG(1);
			tree.root.right = new NodeDAG(2);
			tree.root.right.right = new NodeDAG(3);
			assertEquals("LCA of 2 and 3: ", 2, tree.functionLCADAG(2, 3));	
			assertEquals("LCA of 3 and 1: ", 1, tree.functionLCADAG(3, 1));
		}
	
	//dag tests	
	@Test
	public void testDAG1() {
//	      1
//	      |
//	      ^
//		  2 -<- 3
//		  |
//    	  ^
//		  4 -<- 6
	// 	  \    /
	//	   ^   ^
		// 	 5
	DAG graph = new DAG();
	NodeDAG root = new NodeDAG(1);
	NodeDAG nodeTwo = new NodeDAG(2);
	NodeDAG nodeThree = new NodeDAG(3);
	NodeDAG nodeFour = new NodeDAG(4);
	NodeDAG nodeFive = new NodeDAG(5);
	NodeDAG nodeSix = new NodeDAG(6);
			graph.addToGraph(root);
			graph.addToGraph(nodeTwo);
			graph.addToGraph(nodeThree);
			graph.addToGraph(nodeFour);
			graph.addToGraph(nodeFive);
			graph.addToGraph(nodeSix);
			graph.addAncestorsToNode(root, nodeTwo);
			graph.addAncestorsToNode(nodeTwo, nodeThree);
			graph.addAncestorsToNode(nodeTwo, nodeFour);
			graph.addAncestorsToNode(nodeFour, nodeFive);
			graph.addAncestorsToNode(nodeFour, nodeSix);
			graph.addAncestorsToNode(nodeSix, nodeFive);
			graph.addAncestorToNode2(nodeFour, nodeFive, 1);
			assertEquals(6, graph.findLCADAG2(root, nodeFive, nodeSix));
			assertEquals(4, graph.findLCADAG2(root, nodeSix, nodeFour));
			assertEquals(2, graph.findLCADAG2(root, nodeSix, nodeThree));
			assertEquals(4, graph.findLCADAG2(root, nodeFour, nodeFive));
			assertEquals(2, graph.findLCADAG2(root, nodeSix, nodeTwo));
			assertEquals(1, graph.findLCADAG2(root, nodeTwo, root));
			assertEquals(1, graph.findLCADAG2(root, root, root));
		}
	
	@Test
	public void testEmptyDAG() {
	DAG graph = new DAG();
			assertEquals(-1, graph.findLCADAG2(null, null, null));
		}
	@Test
	public void testOneNodeDAG() {
	DAG graph = new DAG();
	NodeDAG node = new NodeDAG(1);
			graph.addToGraph(node);
			assertEquals(1, graph.findLCADAG2(node, node, node));
		}
	

}
