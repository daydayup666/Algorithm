package tao;

public class RandomListNodeClone {
	void cloneNodes (RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode!=null) {
			RandomListNode pClone = new RandomListNode(0); 
			pClone.label = pNode.label;
			pClone.next = pNode.next;
			pClone.random = null;
			pNode.next = pClone;
			pNode = pClone.next;
		}
	}
	
	void connectSiblingNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		while(pNode!=null) {
			RandomListNode pClone = pNode.next;
			if(pNode.random!=null) {
				pClone.random = pNode.random.next;
			}
			pNode = pClone.next;
		}
	}
	RandomListNode reconnectNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode pCloneHead = null;
		RandomListNode pCloneNode = null;
		if(pNode != null) {
			pCloneHead=pCloneNode=pNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		while(pNode!=null){
			pCloneNode.next = pNode.next;
			pCloneNode = pCloneNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		return pCloneHead;
	}
	public RandomListNode Clone(RandomListNode pHead)
    {
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
        return reconnectNodes(pHead);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}