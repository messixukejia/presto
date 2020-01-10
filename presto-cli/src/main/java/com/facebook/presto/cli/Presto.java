/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.cli;

import static io.airlift.airline.SingleCommand.singleCommand;

public final class Presto
{
    private Presto() {}

    public static void main(String[] args)
    {
        //comment_xu：根据传递的参数，初始化一个Console对象，该对象保存了Cli启动时传入的所有参数。
        Console console = singleCommand(Console.class).parse(args);

        //comment_xu：如果是--help或者--version，则屏幕上打印相关信息后直接退出。
        if (console.helpOption.showHelpIfRequested() ||
                console.versionOption.showVersionIfRequested()) {
            return;
        }

        System.exit(console.run() ? 0 : 1);
    }
}
