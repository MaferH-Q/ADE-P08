package Actividades.Avltree;
import Actividades.Exceptions.ItemDuplicated;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    class NodeAVL extends Node<E> {
        protected int bf;

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return this.data + " (bf=" + bf + ")";
        }
    }

    private boolean height;

    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;

        if (node == null) {
            this.height = true;
            return new NodeAVL(x);
        }

        int resC = node.data.compareTo(x);
        if (resC == 0)
            throw new ItemDuplicated(x + " ya se encuentra en el árbol...");

        if (resC < 0) {
            fat.right = insert(x, (NodeAVL) node.right);
            if (this.height) {
                switch (fat.bf) {
                    case -1: fat.bf = 0; this.height = false; break;
                    case  0: fat.bf = 1; this.height = true; break;
                    case  1: fat = balanceToLeft(fat); this.height = false; break;
                }
            }
        } else {
            fat.left = insert(x, (NodeAVL) node.left);
            if (this.height) {
                switch (fat.bf) {
                    case  1: fat.bf = 0; this.height = false; break;
                    case  0: fat.bf = -1; this.height = true; break;
                    case -1: fat = balanceToRight(fat); this.height = false; break;
                }
            }
        }
        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0; hijo.bf = 0;
                return rotateSL(node);
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1: node.bf = 0; hijo.bf = 1; break;
                    case  0: node.bf = 0; hijo.bf = 0; break;
                    case  1: node.bf = 1; hijo.bf = 0; break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                return rotateSL(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0; hijo.bf = 0;
                return rotateSR(node);
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case -1: node.bf = 0; hijo.bf = 1; break;
                    case  0: node.bf = 0; hijo.bf = 0; break;
                    case  1: node.bf = -1; hijo.bf = 0; break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                return rotateSR(node);
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        return p;
    }

    public void preOrder() {
        preOrder((NodeAVL) root);
        System.out.println();
    }

    private void preOrder(NodeAVL node) {
        if (node != null) {
            System.out.print(node + " ");
            preOrder((NodeAVL) node.left);
            preOrder((NodeAVL) node.right);
        }
    }
}