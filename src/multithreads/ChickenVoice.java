package multithreads;

public class ChickenVoice	//Класс с методом main()
{
     EggVoice egg;	//Побочный поток

    public static void main(String[] args)
    {
    	ChickenVoice cv=new ChickenVoice();
    }

    ChickenVoice(){
    	egg = new EggVoice();	//Создание потока
    	Thread t=new Thread(egg);

        System.out.println("Спор начат...");
        t.start(); 			//Запуск потока

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if(t.isAlive())	//Если оппонент еще не сказал последнее слово
        {
            try{
                t.join();	//Подождать пока оппонент закончит высказываться.
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо!");
        }
        else	//если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }

    class EggVoice implements Runnable
    {
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                try{
                    Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
                }catch(InterruptedException e){}

                System.out.println("яйцо!");
            }
            //Слово «яйцо» сказано 5 раз
        }
    }
}