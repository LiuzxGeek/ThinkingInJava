package com.java.thinking.instance;

/*
*@author:liuxian
*@date:2019年6月14日
*/
public class TestSingleInstance {

	public static class HungrySingleInstance {
		private static final HungrySingleInstance instance = new HungrySingleInstance();

		private HungrySingleInstance() {
		}

		public static HungrySingleInstance getInstance() {
			return instance;
		}
	}

	public static class HolderSingleInstance {

		private HolderSingleInstance() {
		}

		private static class SingleHolder {
			private static final HolderSingleInstance instance = new HolderSingleInstance();
		}

		public static HolderSingleInstance getInstance() {
			return SingleHolder.instance;
		}
	}

	public static class LazySingleInstance {
		private static volatile LazySingleInstance instance;

		private LazySingleInstance() {
		}

		public static LazySingleInstance getInstance() {
			if (instance == null) {
				synchronized (LazySingleInstance.class) {
					if (instance == null) {
						instance = new LazySingleInstance();
					}
				}
			}
			return instance;
		}
	}

}
