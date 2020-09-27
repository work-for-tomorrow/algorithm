    public static List<Long> mergeSort(List<Long> nums){
        List<Long> left = nums.subList(0, nums.size()/2);
        List<Long> right = nums.subList(nums.size() / 2, nums.size());
        return doSort(left, right);
    }

    private static List<Long> doSort(List<Long> left, List<Long> right) {
        Scanner scanner = new Scanner(System.in);
        long nextLong = scanner.nextLong();
        System.out.println(Long.toHexString(nextLong));
        if (left.size() > 1) {
            left = mergeSort(left);
        }
        if (right.size() > 1) {
            right = mergeSort(right);
        }
        ArrayList<Long> longs = new ArrayList<>();
        if (left.size() == 0 && right.size() == 0) {
           return longs;
        }
        else if (left.size() == 0 && right.size() == 1){
            longs.add(right.get(0));
        }else if (right.size() == 0 && left.size() == 1){
            longs.add(left.get(0));
        }else if (right.size() == 1 && left.size() == 1){
            Long l = left.get(0);
            Long r = right.get(0);
            if (r > l) {
                longs.add(l);
                longs.add(r);
            }else {
                longs.add(r);
                longs.add(l);
            }
        }else {
                int lIndex = 0;
                int rIndex = 0;
                for (int i = 0; i < left.size() + right.size(); i++) {
                    if (lIndex == left.size()){
                        longs.addAll(right.subList(rIndex, right.size()));
                        break;
                    }else if (rIndex == right.size()){
                        longs.addAll(left.subList(lIndex, left.size()));
                        break;
                    }
                   if (left.get(lIndex) < right.get(rIndex)){
                      longs.add(left.get(lIndex++));
                   }else {
                       longs.add(right.get(rIndex++));
                   }
                }
        }
        return longs;
    }