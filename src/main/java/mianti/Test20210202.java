package mianti;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同时有N个商品（用long类型的商品id表示），每个商品都可以被任何一个用户（longtype的用户id）订阅，
 * 每被订阅一次，该商品的订阅数加1，同一个用户对同一个商品只能订阅一次。编辑写一个类，
 * 用3个方法提供以下功能（这3个方法都是在单机多线程环境下调用）：
 * 1）为指定的用户id订阅指定的商品id
 * 2）返回所有商品的订阅总数
 * 3）根据商品ID返回这个商品的订阅数
 * 2021-02-02 18:18:20
 * <p>
 * <p>
 * 商户：id，被订阅数，
 * 用户：id，订阅商品
 * 初始化： 固定N个商品
 */
public class Test20210202 {

    public static final int N = 10;
    public static Map<Long, Good> goodMap = new HashMap<Long, Good>();


    public static void main(String[] args) {
        Test20210202 test = new Test20210202();
        test.init();

        User user = test.new User(1L, new HashMap<Long, Good>());
        User user2 = test.new User(2L, new HashMap<Long, Good>());
        User user3 = test.new User(3L, new HashMap<Long, Good>());
        User user4 = test.new User(4L, new HashMap<Long, Good>());

        Good good = goodMap.get(1L);
        Good good2 = goodMap.get(2L);
        Good good3 = goodMap.get(3L);
        Good good4 = goodMap.get(4L);
        Good good5 = goodMap.get(5L);
        Good good6 = goodMap.get(6L);
        Good good7 = goodMap.get(7L);

        test.subscrib(user, good);
        test.subscrib(user2, good);
        test.subscrib(user2, good2);
        test.subscrib(user3, good4);
        test.subscrib(user4, good);
        user4.subscrib(good);
        System.out.println("总订阅数" + test.getAllGoodsSubsNum());
        System.out.println("商品1订阅数" + test.getGoodsSubsById(1L));

    }

    public void init() {
        for (int i = 1; i <= N; i++) {
            Long goodid = Long.parseLong(i + "");
            goodMap.put(goodid, new Good(goodid, new AtomicLong(0)));
        }
    }

    public void subscrib(User user, Good good) {
        user.subscrib(good);
    }

    public long getAllGoodsSubsNum() {
        long num = 0L;
        for (Good good : goodMap.values()) {
            num += good.getSubsCribedNum().longValue();
        }
        return num;
    }

    public long getGoodsSubsById(Long id) {
        return goodMap.get(id).getSubsCribedNum().longValue();
    }


    class Good {
        private Long id;
        private AtomicLong subsCribedNum;

        public Good(Long id, AtomicLong subsCribedNum) {
            this.id = id;
            this.subsCribedNum = subsCribedNum;
        }

        public void addSubsCribNum() {
            subsCribedNum.incrementAndGet();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public AtomicLong getSubsCribedNum() {
            return subsCribedNum;
        }

        public void setSubsCribedNum(AtomicLong subsCribedNum) {
            this.subsCribedNum = subsCribedNum;
        }
    }

    class User {
        private Long id;
        private HashMap<Long, Good> goods;
        private ReentrantLock lock = new ReentrantLock();

        public User(Long id, HashMap<Long, Good> goods) {
            this.id = id;
            this.goods = goods;
        }

        public void subscrib(Good good) {
            try {
                lock.lock();
                Good g = goods.get(good.getId());
                if (g == null) {
                    good.addSubsCribNum();
                    goods.put(good.getId(), good);
                    System.out.println("user" + this + "订阅商品" + good.getId() + "成功");

                } else {
                    System.out.println("已经订阅过");
                }
            } finally {
                lock.unlock();
            }
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public HashMap<Long, Good> getGoods() {
            return goods;
        }

        public void setGoods(HashMap<Long, Good> goods) {
            this.goods = goods;
        }
    }
}
