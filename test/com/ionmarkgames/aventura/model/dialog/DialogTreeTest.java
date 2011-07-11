package com.ionmarkgames.aventura.model.dialog;

import java.util.Map;
import java.util.Map.Entry;

import com.ionmarkgames.aventura.controller.DialogController;
import com.ionmarkgames.aventura.model.resources.IStoryResource;
import com.ionmarkgames.aventura.model.resources.StringResource;

public class DialogTreeTest {

	private static StringResource A = new StringResource("Hello there.");
	private static StringResource B = new StringResource("What is your name?");
	private static StringResource C = new StringResource("My name is Bob.");
	private static StringResource D = new StringResource("Nice to meet you Bob");
	private static StringResource E = new StringResource("Nice to meet you too!");
	private static StringResource F = new StringResource("Bob is not a very original name");
	private static StringResource G = new StringResource("Well fuck you too!");
	
	private static StringResource H = new StringResource("What is this?");
	private static StringResource I = new StringResource("This is a test.");
	private static StringResource J = new StringResource("I'm not sure I get it...");
	private static StringResource K = new StringResource("You will in time.");
	private static StringResource L = new StringResource("Oh ok.");
	private static StringResource M = new StringResource("You are a sharp one!");
	
	private DialogTree<String> dialogTree = new DialogTree<String>();
	
	public static void main(String[] argv) {
		DialogTreeTest test = new DialogTreeTest();
		test.testTreeCreate();
	}
	
	public void testTreeCreate() {
		
		DialogNode<String> a = new DialogNode<String>(A);
		DialogNode<String> b = new DialogNode<String>(B);
		b.setId(1l);
		DialogNode<String> c = new DialogNode<String>(C);
		DialogNode<String> d = new DialogNode<String>(D);
		d.setId(1l);
		DialogNode<String> e = new DialogNode<String>(E);
		DialogNode<String> f = new DialogNode<String>(F);
		f.setId(2l);
		DialogNode<String> g = new DialogNode<String>(G);
		
		DialogVector<String> bc = new DialogVector<String>();
		bc.setPlayerDialog(b);
		bc.setResponseDialog(c);
		a.addVector(bc);
		
		DialogVector<String> de = new DialogVector<String>();
		de.setPlayerDialog(d);
		de.setResponseDialog(e);
		c.addVector(de);
		
		DialogVector<String> fg = new DialogVector<String>();
		fg.setPlayerDialog(f);
		fg.setResponseDialog(g);
		c.addVector(fg);
		
		dialogTree.setRoot(a);
		
		DialogController<String> controller = new DialogController<String>();
		controller.setDialogTree(dialogTree);
		
		System.out.println(controller.startConversation().getResource());
		
		Map<Long, IStoryResource<String>> options = controller.getDialogOptions();
		for (Entry<Long, IStoryResource<String>> entry : options.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getResource());
		}
		
		IStoryResource<String> resp = controller.chooseOption(1l);
		System.out.println(resp.getResource());
		
		options = controller.getDialogOptions();
		for (Entry<Long, IStoryResource<String>> entry : options.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getResource());
		}
		
		resp = controller.chooseOption(2l);
		System.out.println(resp.getResource());
		
		options = controller.getDialogOptions();
		for (Entry<Long, IStoryResource<String>> entry : options.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getResource());
		}
	}
}