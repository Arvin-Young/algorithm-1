package com.company.test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicRef {

    private static class Record {
        private Date lastUpdateTime;
        private AtomicLong total;

        public Record(Date lastUpdateTime, AtomicLong total) {
            this.lastUpdateTime = lastUpdateTime;
            this.total = total;
        }

        public AtomicLong getTotal() {
            return total;
        }
    }

    public static void main(String[] args) {
        AtomicReference<Record> ref = new AtomicReference<>();
        Record record = ref.get();
        record.getTotal().incrementAndGet();
        ref.compareAndSet(record, new Record(new Date(), record.getTotal()));
    }
}
