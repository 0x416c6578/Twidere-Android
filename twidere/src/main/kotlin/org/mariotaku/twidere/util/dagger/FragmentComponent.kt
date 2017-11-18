/*
 *             Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2017 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.util.dagger

import dagger.Component
import org.mariotaku.twidere.dagger.module.ApplicationModule
import org.mariotaku.twidere.dagger.module.ChannelModule
import org.mariotaku.twidere.fragment.BaseDialogFragment
import org.mariotaku.twidere.fragment.BaseFragment
import org.mariotaku.twidere.fragment.BasePreferenceFragment
import org.mariotaku.twidere.fragment.media.ExoPlayerPageFragment
import org.mariotaku.twidere.fragment.media.VideoPageFragment
import org.mariotaku.twidere.fragment.preference.ThemedPreferenceDialogFragmentCompat
import org.mariotaku.twidere.util.lang.ApplicationContextSingletonHolder
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ChannelModule::class))
interface FragmentComponent {

    fun inject(fragment: BaseFragment)

    fun inject(fragment: BaseDialogFragment)

    fun inject(fragment: BasePreferenceFragment)

    fun inject(fragment: ExoPlayerPageFragment)

    fun inject(fragment: VideoPageFragment)

    fun inject(fragment: ThemedPreferenceDialogFragmentCompat)

    companion object : ApplicationContextSingletonHolder<FragmentComponent>(creation@ { application ->
        return@creation DaggerFragmentComponent.builder()
                .applicationModule(ApplicationModule.getInstance(application))
                .channelModule(ChannelModule.getInstance(application))
                .build()
    })
}