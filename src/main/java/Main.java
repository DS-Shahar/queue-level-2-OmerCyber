class Main {
  public static void main(String[] args) 
  {
    
  }
  public static Queue<Character> q1_copyChar(Queue<Character> q)
{
    Queue<Character> t = new Queue<Character>();
    Queue<Character> c = new Queue<Character>();

    while (!q.isEmpty())
    {
        char x = q.remove();
        t.insert(x);
        c.insert(x);
    }

    while (!t.isEmpty())
    {
        q.insert(t.remove());
    }

    return c;
}

public static Queue<Integer> q1_runsSizes(Queue<Character> q)
{
    Queue<Character> t = q1_copyChar(q);
    Queue<Integer> ans = new Queue<Integer>();

    if (t.isEmpty())
        return ans;

    char prev = t.remove();
    int count = 1;

    while (!t.isEmpty())
    {
        char x = t.remove();
        if (x == prev)
        {
            count++;
        }
        else
        {
            ans.insert(count);
            prev = x;
            count = 1;
        }
    }

    ans.insert(count); 
    return ans;
}גודל קלט n
  סיבוכיות O(n)
  public static Queue<Integer> q5_mergeSorted(Queue<Integer> q1, Queue<Integer> q2)
{
    Queue<Integer> a = q1_copy(q1);
    Queue<Integer> b = q1_copy(q2);
    Queue<Integer> ans = new Queue<Integer>();

    boolean hasA = !a.isEmpty();
    boolean hasB = !b.isEmpty();

    int x = 0, y = 0;
    if (hasA) x = a.remove();
    if (hasB) y = b.remove();

    while (hasA && hasB)
    {
        if (x <= y)
        {
            ans.insert(x);
            if (!a.isEmpty()) x = a.remove();
            else hasA = false;
        }
        else
        {
            ans.insert(y);
            if (!b.isEmpty()) y = b.remove();
            else hasB = false;
        }
    }

    if (hasA)
    {
        ans.insert(x);
        while (!a.isEmpty()) ans.insert(a.remove());
    }
    if (hasB)
    {
        ans.insert(y);
        while (!b.isEmpty()) ans.insert(b.remove());
    }

    return ans;
}
סיבוכיות o(n+m)
  public static int q6_sumLongestEvenRun(Queue<Integer> q)
{
    Queue<Integer> t = q1_copy(q);

    int curLen = 0;
    int curSum = 0;

    int bestLen = 0;
    int bestSum = 0;

    while (!t.isEmpty())
    {
        int x = t.remove();

        if (x % 2 == 0)
        {
            curLen++;
            curSum += x;
        }
        else
        {
            if (curLen > bestLen)
            {
                bestLen = curLen;
                bestSum = curSum;
            }
            curLen = 0;
            curSum = 0;
        }
    }

    if (curLen > bestLen)
    {
        bestLen = curLen;
        bestSum = curSum;
    }

    return bestSum;
}
סיבוכיותo(n)
  import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSort {

    public static void radixSort(Queue<Integer> q) {

        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayDeque<>();
        }

        int max = 0;
        for (int x : q) {
            if (x > max) max = x;
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {

            while (!q.isEmpty()) {
                int x = q.remove();
                int d = (x / exp) % 10;
                buckets[d].add(x);
            }

            for (int i = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    q.add(buckets[i].remove());
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(170);
        q.add(45);
        q.add(75);
        q.add(90);
        q.add(802);
        q.add(24);
        q.add(2);
        q.add(66);

        radixSort(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
      public static boolean hasDuplicates(Queue<String> q)
{
    Queue<String> seen = new Queue<String>();
    Queue<String> tmp = new Queue<String>();

    boolean dup = false;

    while (!q.isEmpty())
    {
        String s = q.remove();

        if (!dup && isIn(seen, s))
            dup = true;

        seen.insert(s);
        tmp.insert(s);
    }

    while (!tmp.isEmpty())
        q.insert(tmp.remove());

    return dup;
}
    }
}


}
