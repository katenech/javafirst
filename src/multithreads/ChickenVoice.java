package multithreads;

public class ChickenVoice	//����� � ������� main()
{
     EggVoice egg;	//�������� �����

    public static void main(String[] args)
    {
    	ChickenVoice cv=new ChickenVoice();
    }

    ChickenVoice(){
    	egg = new EggVoice();	//�������� ������
    	Thread t=new Thread(egg);

        System.out.println("���� �����...");
        t.start(); 			//������ ������

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);		//���������������� ����� �� 1 �������
            }catch(InterruptedException e){}

            System.out.println("������!");
        }

        //����� ������� ������� 5 ���

        if(t.isAlive())	//���� �������� ��� �� ������ ��������� �����
        {
            try{
                t.join();	//��������� ���� �������� �������� �������������.
            }catch(InterruptedException e){}

            System.out.println("������ ��������� ����!");
        }
        else	//���� �������� ��� �������� �������������
        {
            System.out.println("������ ��������� ������!");
        }
        System.out.println("���� ��������!");
    }

    class EggVoice implements Runnable
    {
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                try{
                    Thread.sleep(1000);		//���������������� ����� �� 1 �������
                }catch(InterruptedException e){}

                System.out.println("����!");
            }
            //����� ����� ������� 5 ���
        }
    }
}