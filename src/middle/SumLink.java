package middle;

import java.util.Random;

public class SumLink {



    public static void main(String[] args){
        LinkNode linkNode1=createLinkNode(3);
        LinkNode linkNode2=createLinkNode(5);
        linkNode1.print();
        linkNode2.print();

        LinkNode linkNode=sumLinkNode(linkNode1,linkNode2);
        linkNode.print();
    }

    public static LinkNode sumLinkNode(final LinkNode linkNode1,final LinkNode linkNode2){
        LinkNode resultHeadNode=null;
        LinkNode resultLastNode=null;

        LinkNode node1Curr=linkNode1;
        LinkNode node2Curr=linkNode2;

        int overflow=0;
        while(node1Curr!=null||node2Curr!=null){
            int sum=((node1Curr!=null)?node1Curr.getValue():0)+((node2Curr!=null)?node2Curr.getValue():0);
            int resultBitValue=(sum+overflow)%10;
            if(sum+overflow>=10){
                overflow=1;
            }else{
                overflow=0;
            }
            LinkNode resultBitNode = new LinkNode(resultBitValue);
            if(resultHeadNode==null){
                resultHeadNode=resultBitNode;
            }
            if(resultLastNode==null){
                resultLastNode=resultBitNode;
            }else{
                resultLastNode.setNext(resultBitNode);
                resultLastNode=resultBitNode;
            }

            if(node1Curr!=null){
                node1Curr=node1Curr.getNext();
            }

            if(node2Curr!=null){
                node2Curr=node2Curr.getNext();
            }
        }
        return resultHeadNode;
    }



    static class LinkNode{
        private int value;
        private LinkNode next;
        public LinkNode(int value){
         this.value=value;
        }
        public void setNext(LinkNode next){
            this.next=next;
        }
        public LinkNode getNext(){
            return this.next;
        }
        public int getValue(){
            return this.value;
        }

        public void print(){
            StringBuilder sb=new StringBuilder();
            sb.append(value);
            LinkNode n=this.next;
            while(n!=null){
                sb.append(n.getValue());
                n=n.next;
            }
            System.out.println(String.format("%10s",sb.reverse().toString()));
        }
    }


    public static LinkNode createLinkNode(int length){

        Random randomForBit=new Random();
        //长度
        if(length==1){
            return new LinkNode(randomForBit.nextInt());
        }else{
            LinkNode last=null;
            LinkNode head=null;
            for(int i=0;i<length;i++){
                if(i==0){
                    last=new LinkNode(randomForBit.nextInt(9));
                    head=last;
                }else if(i<length-1){
                    last.setNext(new LinkNode(randomForBit.nextInt(9)));
                    last=last.getNext();
                }else{
                    int value=0;
                    while((value=randomForBit.nextInt(9))!=0){
                        break;
                    }
                    last.setNext(new LinkNode(value));
                    last=last.getNext();
                }
            }

            return head;
        }


    }
}
